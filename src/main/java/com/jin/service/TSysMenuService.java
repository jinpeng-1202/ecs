package com.jin.service;


import com.jin.base.BaseService;
import com.jin.bean.SubMenu;
import com.jin.bean.SysUser;
import com.jin.model.TSysMenu;

import java.util.List;

public interface TSysMenuService  extends BaseService<TSysMenu>   {

    List<TSysMenu> getAllMenu();

    List<TSysMenu> getAllMenuByRoles(List<String> roles);

    List<SubMenu> querySubMenu(SysUser sysUser);

}
