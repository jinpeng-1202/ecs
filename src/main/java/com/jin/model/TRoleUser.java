package  com.jin.model; 

import java.util.Date;

/**
*t_role_user
* 表名：
*/
public class TRoleUser extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private Long  userId; 
    /**  */ 
    private Long  roleId; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /**  */ 
    public Long getUserId(){
        return userId;
    }

    /**  */ 
    public void setUserId(Long  userId){
        this.userId = userId;
    }
    /**  */ 
    public Long getRoleId(){
        return roleId;
    }

    /**  */ 
    public void setRoleId(Long  roleId){
        this.roleId = roleId;
    }
}
