package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.model.TSysMenu;
import com.jin.service.TSysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysMenuServiceImpl extends BaseServiceImpl<TSysMenu>  implements TSysMenuService {


    @Override
    public List<TSysMenu> getAllMenu() {

        List<TSysMenu> menus=new ArrayList<>();
        return menus;
    }


    @Override
    public List<TSysMenu> getAllMenuByRoles(List<String> roles) {

        Map<String,Object> map=new HashMap<>();
        map.put("roleNames",roles);
        return getListBySqlId("getMenuByRoles",map,new TSysMenu());
    }
}
