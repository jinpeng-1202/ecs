package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.bean.SysMenu;
import com.jin.model.TSysMenu;
import com.jin.model.TSysRole;
import com.jin.service.TSysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TSysMenuServiceImpl extends BaseServiceImpl<TSysMenu>  implements TSysMenuService {


    @Override
    public List<SysMenu> getAllMenu() {

        List<SysMenu> menus=new ArrayList<>();
        SysMenu menu=new SysMenu();
        menu.setId(1L);
        menu.setName("用戶管理");
        menu.setUrl("/user/*");

        List<TSysRole> roles = new ArrayList<>();
        TSysRole role = new TSysRole();
        role.setId(1L);
        role.setRoleName("ROLE_ADMIN");
        roles.add(role);
        menu.setRoles(roles);

        menus.add(menu);
        return menus;
    }
}
