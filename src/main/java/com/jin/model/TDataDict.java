package  com.jin.model; 

import java.util.Date;

/**
*t_data_dict
* 表名：数据字典表
*/
public class TDataDict extends BaseModel {
    /** 主键ID  */ 
    private Long  id; 
    /** 数据字典类型  */ 
    private String  type; 
    /** 字典名称  */ 
    private String  name; 
    /** 字典编码  */ 
    private String  code; 
    /** 排序号  */ 
    private Integer  seqNo; 
    /** 描述信息 */ 
    private String  description; 
    /**  */ 
    private String  status; 
    /**  */ 
    private String  assetCode; 

    /** 主键ID  */ 
    public Long getId(){
        return id;
    }

    /** 主键ID  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /** 数据字典类型  */ 
    public String getType(){
        return type;
    }

    /** 数据字典类型  */ 
    public void setType(String  type){
        this.type = type;
    }
    /** 字典名称  */ 
    public String getName(){
        return name;
    }

    /** 字典名称  */ 
    public void setName(String  name){
        this.name = name;
    }
    /** 字典编码  */ 
    public String getCode(){
        return code;
    }

    /** 字典编码  */ 
    public void setCode(String  code){
        this.code = code;
    }
    /** 排序号  */ 
    public Integer getSeqNo(){
        return seqNo;
    }

    /** 排序号  */ 
    public void setSeqNo(Integer  seqNo){
        this.seqNo = seqNo;
    }
    /** 描述信息 */ 
    public String getDescription(){
        return description;
    }

    /** 描述信息 */ 
    public void setDescription(String  description){
        this.description = description;
    }
    /**  */ 
    public String getStatus(){
        return status;
    }

    /**  */ 
    public void setStatus(String  status){
        this.status = status;
    }
    /**  */ 
    public String getAssetCode(){
        return assetCode;
    }

    /**  */ 
    public void setAssetCode(String  assetCode){
        this.assetCode = assetCode;
    }
}
