package  com.jin.model; 

import java.util.Date;

/**
*t_role_menu
* 表名：
*/
public class TRoleMenu extends BaseModel {
    /**  */ 
    private Long  id; 
    /**  */ 
    private Long  roleId; 
    /**  */ 
    private Long  menuId; 

    /**  */ 
    public Long getId(){
        return id;
    }

    /**  */ 
    public void setId(Long  id){
        this.id = id;
    }
    /**  */ 
    public Long getRoleId(){
        return roleId;
    }

    /**  */ 
    public void setRoleId(Long  roleId){
        this.roleId = roleId;
    }
    /**  */ 
    public Long getMenuId(){
        return menuId;
    }

    /**  */ 
    public void setMenuId(Long  menuId){
        this.menuId = menuId;
    }
}
