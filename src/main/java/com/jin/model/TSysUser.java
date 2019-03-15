package  com.jin.model; 

import java.util.Date;

/**
*t_sys_user
* 表名：
*/
public class TSysUser extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private String  username; 
    /**  */ 
    private String  password; 
    /** 0:false 1:true */ 
    private Boolean  enabled; 
    /**  */ 
    private Boolean  accountNonExpired; 
    /**  */ 
    private Boolean  accountNonLocked; 
    /**  */ 
    private Boolean  credentialsNonExpired; 
    /**  */ 
    private Date  createTime; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /**  */ 
    public String getUsername(){
        return username;
    }

    /**  */ 
    public void setUsername(String  username){
        this.username = username;
    }
    /**  */ 
    public String getPassword(){
        return password;
    }

    /**  */ 
    public void setPassword(String  password){
        this.password = password;
    }
    /** 0:false 1:true */ 
    public Boolean getEnabled(){
        return enabled;
    }

    /** 0:false 1:true */ 
    public void setEnabled(Boolean  enabled){
        this.enabled = enabled;
    }
    /**  */ 
    public Boolean getAccountNonExpired(){
        return accountNonExpired;
    }

    /**  */ 
    public void setAccountNonExpired(Boolean  accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    /**  */ 
    public Boolean getAccountNonLocked(){
        return accountNonLocked;
    }

    /**  */ 
    public void setAccountNonLocked(Boolean  accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    /**  */ 
    public Boolean getCredentialsNonExpired(){
        return credentialsNonExpired;
    }

    /**  */ 
    public void setCredentialsNonExpired(Boolean  credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }
    /**  */ 
    public Date getCreateTime(){
        return createTime;
    }

    /**  */ 
    public void setCreateTime(Date  createTime){
        this.createTime = createTime;
    }
}
