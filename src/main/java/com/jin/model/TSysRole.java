package  com.jin.model; 

import java.util.Date;

/**
*t_sys_role
* 表名：
*/
public class TSysRole extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private String  roleName; 
    /**  */ 
    private Date  createTime; 
    /**  */ 
    private String  name; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /**  */ 
    public String getRoleName(){
        return roleName;
    }

    /**  */ 
    public void setRoleName(String  roleName){
        this.roleName = roleName;
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
    public String getName(){
        return name;
    }

    /**  */ 
    public void setName(String  name){
        this.name = name;
    }
}
