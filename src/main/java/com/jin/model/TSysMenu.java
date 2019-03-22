package  com.jin.model; 

import java.util.Date;

/**
*t_sys_menu
* 表名：
*/
public class TSysMenu extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private String  url; 
    /**  */ 
    private String  path; 
    /**  */ 
    private Long  parentId; 
    /**  */ 
    private String  name; 
    /**  */ 
    private Date  createTime; 
    /**  */ 
    private String  urlCode; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /**  */ 
    public String getUrl(){
        return url;
    }

    /**  */ 
    public void setUrl(String  url){
        this.url = url;
    }
    /**  */ 
    public String getPath(){
        return path;
    }

    /**  */ 
    public void setPath(String  path){
        this.path = path;
    }
    /**  */ 
    public Long getParentId(){
        return parentId;
    }

    /**  */ 
    public void setParentId(Long  parentId){
        this.parentId = parentId;
    }
    /**  */ 
    public String getName(){
        return name;
    }

    /**  */ 
    public void setName(String  name){
        this.name = name;
    }
    /**  */ 
    public Date getCreateTime(){
        return createTime;
    }

    /**  */ 
    public void setCreateTime(Date  createTime){
        this.createTime = createTime;
    }
    /**  */ 
    public String getUrlCode(){
        return urlCode;
    }

    /**  */ 
    public void setUrlCode(String  urlCode){
        this.urlCode = urlCode;
    }
}
