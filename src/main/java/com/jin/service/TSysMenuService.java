package com.jin.service;


import com.jin.base.BaseService;
import com.jin.bean.SysMenu;
import com.jin.model.TSysMenu;

import java.util.List;

public interface TSysMenuService  extends BaseService<TSysMenu>   {

    List<SysMenu> getAllMenu();

}
