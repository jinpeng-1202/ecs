package com.jin.bean;

import com.jin.model.TSysMenu;
import com.jin.model.TSysRole;

import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/16.
 */
public class SysRole {

    private TSysRole sysRole;
    /**
     * 角色拥有的资源(菜单)列表
     */
    private List<TSysMenu> menus;

    public List<TSysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<TSysMenu> menus) {
        this.menus = menus;
    }

    public TSysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(TSysRole sysRole) {
        this.sysRole = sysRole;
    }
}
