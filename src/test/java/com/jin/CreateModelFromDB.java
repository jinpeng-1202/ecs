package com.jin;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateModelFromDB {
    //驱动
    private static final String className = "com.mysql.jdbc.Driver";
    //url  58.35.140.73   192.168.1.100
    private static final String  dbname="work";
    private static final String url="jdbc:mysql://47.111.18.88:3306/"+dbname+"?characterEncoding=UTF-8";
    //用户名
    private static final String username="user";
    //密码
    private static final String password="userJinp+1202";
    //	连
    //
    // 接
    private static Connection conn=null;


    private static String javapath="D:\\my-git\\ecs\\src\\main\\java\\com\\jin\\model\\";
    private static String xmlpath="D:\\my-git\\ecs\\src\\main\\resources\\mapper\\";

    private static String servicePath="D:\\my-git\\ecs\\src\\main\\java\\com\\jin\\service\\";
    private static String serviceImplPath="D:\\my-git\\ecs\\src\\main\\java\\com\\jin\\service\\impl\\";

    private static String mappingPackage="com.jin.dao";
    private static String javaPackage="com.jin.model";


    public static void main(String[] args) {

        conn =getConnection();

        try {
            CreateModelFromDB dbModel=new CreateModelFromDB() ;
            Map<String,String>map=dbModel. getTableName();
            for(Map.Entry<String, String> en:map.entrySet()){
                if( !en.getKey().equalsIgnoreCase("t_role_user")){
                    continue;
                }
                System.out.println(en.getKey());
                String model=dbModel.createModel(en.getKey(),en.getValue());
                FileUtils.write(new File(javapath+dbModel.getClassName(en.getKey())+".java"), model);
                List<String > xml=dbModel.createModelXml(en.getKey(),en.getValue());
                File xmlFile=new File(xmlpath+dbModel.getClassName(en.getKey())+"Mapper.xml");
                if(!xmlFile.exists()){
                    FileUtils.writeLines(xmlFile, xml);
                }else {
                    List<String > list=FileUtils.readLines(xmlFile);
                    List<String > oldList=new ArrayList<>();
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).indexOf("******")>0){
                            i++;
                            oldList= list.subList(i,list.size());
                            break;
                        }
                    }
                    xml.remove(xml.size()-1);
                    xml.addAll(oldList);
                    FileUtils.writeLines(xmlFile, xml);
                }

                File servceFile =new File(servicePath+dbModel.getClassName(en.getKey())+"Service.java");
                if(!servceFile.exists()){
                    String serviceStr=dbModel.createService(dbModel.getClassName(en.getKey()));
                    FileUtils.write(servceFile, serviceStr);
                }

                File file=new File(serviceImplPath+dbModel.getClassName(en.getKey())+"ServiceImpl.java");
                if(!file.exists()){
                    String serviceImplStr=dbModel.createServiceImpl(dbModel.getClassName(en.getKey()));
                    FileUtils.write(file, serviceImplStr);
                }


            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public  String createServiceImpl(String name){
        StringBuffer sb=new StringBuffer();
        sb.append("package com.jin.service.impl; \n\n");
        sb.append("import com.jin.base.BaseServiceImpl;\n");
        sb.append("import com.jin.model."+name+";\n");
        sb.append("import com.jin.service."+name+"Service;\n");

        sb.append("import org.springframework.stereotype.Service;\n");
        sb.append("@Service\n");
        sb.append("public class "+name+"ServiceImpl extends BaseServiceImpl<"+name+">  implements "+name+"Service {\n");

        sb.append("}\n");
        return sb.toString();
    }


    public  String createService(String name){
        StringBuffer sb=new StringBuffer();
        sb.append("package com.jin.service; \n\n\n");
        sb.append("import com.jin.model."+name+";\n");
        sb.append("import com.jin.base.BaseService;\n");
        sb.append("public interface "+name+"Service  extends BaseService<"+name+">   {\n\n\n");
        sb.append("}\n");
        return sb.toString();
    }



    public  Map<String,String> getTableName() throws Exception{
        String sql="SELECT table_name,table_comment FROM "
                + "  information_schema.tables WHERE TABLE_SCHEMA ='"+dbname+"' and table_name like 'T\\_%'  ORDER BY table_name";

        PreparedStatement pst=conn.prepareStatement(sql);
        ResultSet rs=  pst.executeQuery();
        Map<String,String> map=new HashMap<String,String>();
        while(rs.next()){
            String tableName=rs.getString("table_name");
            String table_comment=rs.getString("table_comment");
            map.put(tableName, table_comment);
        }
        closeConnection(conn, pst, rs);
        return map;
    }
    public String createModel(String tableName,String tableComment) throws Exception{

        String sql="SELECT column_name,column_type ,column_comment FROM "
                + "  information_schema.columns WHERE TABLE_SCHEMA ='"+dbname+"' AND table_name  ='"+tableName+"' ORDER BY ordinal_position";
        PreparedStatement pst=conn.prepareStatement(sql);
        ResultSet rs=  pst.executeQuery();

        StringBuffer sb=new StringBuffer();
        sb.append("package  "+javaPackage+"; \n\n");
        sb.append("import java.util.Date;\n\n");
        sb.append("/**\n");
        sb.append("*"+tableName+"\n");
        sb.append("* 表名："+tableComment+"\n");
        sb.append("*/\n");
//		T_CORPORATION_RIGTH_IFNO
        sb.append("public class "+getClassName(tableName)+" extends BaseModel {\n");

        StringBuffer sm=new StringBuffer();
        while(rs.next()){
            String column_name=rs.getString("column_name");
            String column_comment=rs.getString("column_comment");
            String column_type=rs.getString("column_type");
            sb.append("    /** "+column_comment+" */ \n");
            String propertiesName=getPropertiesName(column_name);
            String first=propertiesName.substring(0,1);
            String firstUpperCOl = propertiesName.replaceFirst(first,first.toUpperCase());
            sb.append("    private "+getJavaType(column_type)+"  "+propertiesName+"; \n");

            sm.append("    /** "+column_comment+" */ \n");
            sm.append("    public "+getJavaType(column_type)+" get"+firstUpperCOl+"(){\n");
            sm.append("        return "+propertiesName+";\n");
            sm.append("    }\n\n");

            sm.append("    /** "+column_comment+" */ \n");
            sm.append("    public void set"+firstUpperCOl+"("+getJavaType(column_type) +"  "+propertiesName+"){\n");
            sm.append("        this."+propertiesName+" = "+propertiesName+";\n");
            sm.append("    }\n");
        }
        sb.append("\n");
        sb.append(sm);

        sb.append("}\n");
        closeConnection(conn, pst, rs);
        return sb.toString();
    }



    public List<String> createModelXml(String tableName, String tableComment) throws Exception{

        String sql="SELECT column_name,column_type ,column_comment FROM "
                + "  information_schema.columns WHERE TABLE_SCHEMA ='"+dbname+"' AND table_name  ='"+tableName+"' ORDER BY ordinal_position";
        PreparedStatement pst=conn.prepareStatement(sql);
        ResultSet rs=  pst.executeQuery();



        List<String> sb=new ArrayList<>();
        Map<String,String> map=new HashMap<String,String>();

        while(rs.next()){
            String column_name=rs.getString("column_name");
            String column_type=rs.getString("column_type");
            map.put(column_name, column_type);
        }

        sb.add(getResultMap( map,tableName.toLowerCase()));
        sb.add(getInsert( map,tableName.toLowerCase()));
        sb.add(getInsertBatch( map,tableName));


        sb.add(getUpdateDelete( map,tableName));
        sb.add(getObjectById_getList( map,tableName));
        sb.add(getListForPage( map,tableName));

        sb.add("<!--*********************************以下可以写自定义的语句*****************************-->\n");

        sb.add("</mapper>");
        closeConnection(conn, pst, rs);
        return sb ;
    }


    private String getResultMap(Map<String,String> map,String tableName){
        StringBuffer sm=new StringBuffer();
        sm.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sm.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        sm.append("<mapper namespace=\""+mappingPackage+"."+getClassName(tableName)+"Dao\">  \n");
        StringBuffer resultMap=new StringBuffer();
        resultMap.append("\t<resultMap id=\""+getClassNameLower(tableName)+"\" type=\""+javaPackage+"."+getClassName(tableName)+"\" >\n");


        StringBuffer where_condition=new StringBuffer();
        where_condition.append("\t<sql id=\"where_condition\">\n");
        StringBuffer set_condition=new StringBuffer();
        set_condition.append("\t<sql id=\"set_condition\">\n");
        for(Map.Entry<String, String> en:map.entrySet()){
            where_condition.append("\t\t<if test=\""+getPropertiesName(en.getKey().toLowerCase())+" != null\"> AND  "+en.getKey().toLowerCase()+" = #{"+getPropertiesName(en.getKey().toLowerCase())+"}  </if>\n ");
            set_condition.append("\t\t<if test=\""+getPropertiesName(en.getKey().toLowerCase())+" != null\">  "+en.getKey().toLowerCase()+" = #{"+getPropertiesName(en.getKey().toLowerCase())+"}, </if>\n ");
            resultMap.append("\t\t<result property=\""+en.getKey().toLowerCase()+"\" column=\""+en.getKey().toLowerCase()+"\"  />\n");
        }

        where_condition.append("\t</sql>\n\n");
        set_condition.append("\t</sql>\n\n");
        resultMap.append("\n\t</resultMap>\n");


        StringBuffer select_column_list=new StringBuffer();
        select_column_list.append("\t<sql id=\"select_column_list\">\n");
        select_column_list.append("\t\t");
        int i=0;
        for(Map.Entry<String, String> en:map.entrySet()){
            if(i==map.size()-1){
                select_column_list.append(en.getKey().toLowerCase()  +" as "+getPropertiesName(en.getKey().toLowerCase()) );
            }else{
                select_column_list.append( en.getKey().toLowerCase()+" as "+getPropertiesName(en.getKey().toLowerCase())+ "," );
            }
            i++;
        }
        select_column_list.append("\n\t</sql>\n");

        StringBuffer insertcolumn_list=new StringBuffer();
        insertcolumn_list.append("\t<sql id=\"insertcolumn_list\">\n");
        insertcolumn_list.append("\t\t");
        i=0;
        for(Map.Entry<String, String> en:map.entrySet()){
            if(i==map.size()-1){
                insertcolumn_list.append(en.getKey().toLowerCase()   );
            }else{
                insertcolumn_list.append( en.getKey().toLowerCase() + "," );
            }
            i++;
        }
        insertcolumn_list.append("\n\t</sql>\n");
//				sm.append(resultMap);
        sm.append(select_column_list);

        sm.append(insertcolumn_list);
        sm.append(where_condition);
        sm.append(set_condition);
        return sm.toString();
    }

    private String getInsert(Map<String,String> map,String tableName){
        StringBuffer sb=new StringBuffer();
        sb.append("\t<insert id=\"insert\" parameterType=\""+getClassNameLower(tableName)+"\"  keyProperty=\"id\" keyColumn=\"id\" useGeneratedKeys=\"true\"> \n");
        sb.append("\t\t insert into "+(tableName.toLowerCase())+"");
        StringBuffer fileds=new StringBuffer();
        StringBuffer filedsValue=new StringBuffer();
        int i=0;
        for(Map.Entry<String, String> en:map.entrySet()){
            if(i==0){
//				fileds.append( en.getKey().toUpperCase());
                filedsValue.append("\t\t #{"+getPropertiesName(en.getKey().toLowerCase())+"}");
            }else{
//				fileds.append(","+en.getKey().toUpperCase());
                filedsValue.append(",#{"+getPropertiesName(en.getKey().toLowerCase())+"}");
            }
            i++;
        }
        sb.append("\t\t(<include refid=\"insertcolumn_list\" />)");
        sb.append("\t\tvalues \n");
        sb.append("\t\t("+filedsValue+") \n");
        sb.append("\t</insert> \n");
        return sb.toString();
    }


    private String getInsertBatch(Map<String,String> map,String tableName){
        StringBuffer sb=new StringBuffer();
        sb.append("\t<insert id=\"insertBatch\" parameterType=\"ArrayList\"> \n");
        sb.append("\t\t insert into "+(tableName.toLowerCase())+"");

        StringBuffer filedsValue=new StringBuffer();
        int i=0;
        for(Map.Entry<String, String> en:map.entrySet()){
            if(i==0){
                filedsValue.append("\t\t #{obj."+getPropertiesName(en.getKey().toLowerCase())+"}");
            }else{

                filedsValue.append(",#{obj."+getPropertiesName(en.getKey().toLowerCase())+"}");
            }
            i++;
        }
        sb.append("\t\t(<include refid=\"insertcolumn_list\" />)");
        sb.append("\t\t values \n");
        sb.append("\t\t <foreach collection=\"list\" item=\"obj\"  index=\"index\" separator=\",\" >  \n");


        sb.append("\t\t\t("+filedsValue+") \n");

        sb.append(" \t\t</foreach>  \n");
        sb.append("\t</insert> \n");
        return sb.toString();
    }

    private String getUpdateDelete(Map<String,String> map,String tableName){
        StringBuffer sb=new StringBuffer();
        sb.append("\t <update id=\"update\" parameterType=\""+getClassNameLower(tableName)+"\"> \n");
        sb.append("\t\t update   "+(tableName.toLowerCase())+"  \n");
        sb.append("\t\t <set> \n");

        sb.append(  "\t\t\t <include refid=\"set_condition\" />  \n");
        sb.append("\t\t</set>  \n");
        sb.append("\t\t where id=#{id}\n");
        sb.append("\t</update> \n");

        sb.append("\t <delete id=\"delete\" parameterType=\"java.lang.Long\">\n");
        sb.append("\t\tdelete from "+(tableName.toLowerCase())+" where id = #{id}\n");
        sb.append("\t </delete>\n");
        return sb.toString();
    }

    private String   getObjectById_getList (Map<String,String> map,String tableName){
        StringBuffer sb=new StringBuffer();
        sb.append("\t	<select id=\"getObjectById\"  parameterType=\"java.lang.Long\" resultType=\""+getClassNameLower(tableName)+"\"> \n");
        sb.append("       select ");
        StringBuffer fileds=new StringBuffer();
        StringBuffer filedsValue=new StringBuffer();
        int i=0;
        for(Map.Entry<String, String> en:map.entrySet()){
            if(i==0){
                fileds.append( en.getKey().toUpperCase());
            }else{
                fileds.append(","+en.getKey().toUpperCase());
            }
            filedsValue.append("       <isNotEmpty prepend=\"and\" property=\""+en.getKey().toUpperCase()+"\"> "+en.getKey().toUpperCase()+" = #"+en.getKey().toUpperCase()+"# </isNotEmpty>\n");
            i++;
        }
        sb.append( "\t \t <include refid=\"select_column_list\" /> \n" );
        sb.append("\t\t from "+tableName.toLowerCase()+" a   WHERE id = #{id}\n ");
        sb.append("\t </select> \n");

        sb.append(" \t  <select id=\"getList\" parameterType=\""+getClassNameLower(tableName)+"\" resultType=\""+getClassNameLower(tableName)+"\">\n");
        sb.append(" \t \t select  <include refid=\"select_column_list\" /> \n");
        sb.append("\t\t from  "+tableName.toLowerCase()+" a \n");
        sb.append("\t\t <where>\n");
        sb.append("\t\t\t  <include refid=\"where_condition\" />\n");
        sb.append("\t\t </where>\n");
        sb.append("\t\t <if test=\"orderSql != null\">  ORDER BY ${orderSql}  </if> \n");
        sb.append("\t</select> \n");
        return sb.toString();
    }

    private String getListForPage (Map<String,String> map,String tableName){
        StringBuffer sb=new StringBuffer();
        sb.append("	<select id=\"getListForPageCount\"  parameterType=\"java.util.HashMap\" resultType=\"java.lang.Long\"> \n");
        sb.append("     select count(1) as value from "+tableName+" a \n ");

        sb.append("\t\t <where>\n");
        sb.append("\t\t\t  <include refid=\"where_condition\" />\n");
        sb.append("\t\t </where>\n");
        sb.append("\t </select> \n");
        sb.append(" \n");
        sb.append("\t <select id=\"getListForPage\" parameterType=\"java.util.HashMap\" resultType=\""+getClassNameLower(tableName)+"\">\n");
        sb.append("\t\t  select <include refid=\"select_column_list\" />  \n"  );
        sb.append("\t\t  from "+tableName+" a \n");

        sb.append("\t\t <where>\n");
        sb.append("\t\t\t  <include refid=\"where_condition\" />\n");
        sb.append("\t\t </where>\n");

        sb.append("\t\t<if test=\"orderSql != null\">  ORDER BY ${orderSql}  </if> \n");
        sb.append("\t\t LIMIT   #{startRow},  #{endRow} \n ");
        sb.append("\t </select>\n");

        return sb.toString();
    }





    private   String getClassName(String tableName){
        String names[]=tableName.split("_");
        StringBuffer sb=new StringBuffer();
        for(String s:names){
            String first=s.substring(0,1).toUpperCase();
            String other=s.substring(1,s.length()).toLowerCase();
            sb.append(first+other);
        }
        return sb.toString();
    }

    private   String getClassNameLower(String tableName){
        String names[]=tableName.split("_");
        StringBuffer sb=new StringBuffer();
        for(String s:names){
            String first=s.substring(0,1).toUpperCase();
            String other=s.substring(1,s.length()).toLowerCase();
            sb.append(first+other);
        }
        String ss=sb.toString();
        String first=ss.substring(0,1).toLowerCase();
        String other=ss.substring(1,ss.length());
//		return first+other;
        return javaPackage+"."+	getClassName(tableName);
    }


    private String getPropertiesName(String  columnName){
        String name ="";
        char c[]=columnName.toCharArray();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<c.length;i++){
            char ch=c[i];
            if(ch=='_'){
                i++;
                ch=c[i];
                sb.append(Character.toUpperCase(ch));
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
    private String getJavaType(String type){
        if(type.toLowerCase().startsWith("varchar")){
            return "String";
        }
        if(type.toLowerCase().startsWith("datetime")||type.toLowerCase().startsWith("timestamp")){
            return "Date";
        }
        if(type.toLowerCase().startsWith("int") || type.toLowerCase().equalsIgnoreCase("smallint") ){
            return "Integer";
        }
        if(type.toLowerCase().startsWith("tinyint") ){
            return "Boolean";
        }
        if(type.toLowerCase().startsWith("bigint") ){
            return "Long";
        }

        if(type.toLowerCase().startsWith("decimal")){
            return "Double";
        }
        if(type.toLowerCase().startsWith("double")){
            return "Double";
        }else{
            return "String";
        }
    }
    private String getJavaFullType(String type){
        if(type.toLowerCase().startsWith("varchar")){
            return "java.lang.String";
        }
        if(type.toLowerCase().startsWith("datetime")||type.toLowerCase().startsWith("timestamp")){
            return "java.util.Date";
        }
        if(type.toLowerCase().startsWith("int") ){
            return "java.lang.Integer";
        }
        if(type.toLowerCase().startsWith("tinyint") ){
            return "java.lang.Boolean";
        }
        if(type.toLowerCase().startsWith("bigint") ){
            return "java.lang.Long";
        }

        if(type.toLowerCase().startsWith("decimal")){
            return "java.lang.Double";
        }
        if(type.toLowerCase().startsWith("double")){
            return "java.lang.Double";
        }else{
            return "java.lang.String";
        }
    }

    private static Connection getConnection(){

        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return conn;
    }
    private void closeConnection(Connection conn,Statement pst,ResultSet rs){
        try {
            rs.close();
            pst.close();
            //conn.close();
        } catch (Exception e) {
        }
    }
}
