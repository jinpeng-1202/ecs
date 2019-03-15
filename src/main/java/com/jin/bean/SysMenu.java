package com.jin.bean;

import com.jin.model.TSysMenu;
import com.jin.model.TSysRole;

import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
public class SysMenu extends TSysMenu {

    private List<TSysRole> roles;

    public List<TSysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TSysRole> roles) {
        this.roles = roles;
    }
}
