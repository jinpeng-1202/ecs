package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.bean.SubMenu;
import com.jin.bean.SysUser;
import com.jin.common.Constant;
import com.jin.common.ModelConverUtil;
import com.jin.model.TSysMenu;
import com.jin.service.TSysMenuService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysMenuServiceImpl extends BaseServiceImpl<TSysMenu> implements TSysMenuService {


    @Override
    public List<TSysMenu> getAllMenu() {

        List<TSysMenu> menus = new ArrayList<>();
        return menus;
    }


    @Override
    public List<TSysMenu> getAllMenuByRoles(List<String> roles) {

        Map<String, Object> map = new HashMap<>();
        map.put("roleNames", roles);
        return getListBySqlId("getMenuByRoles", map, new TSysMenu());
    }

    @Override
    public List<SubMenu> querySubMenu(SysUser sysUser) {
        List<String> roles = new ArrayList<>();
        List<TSysMenu> sysMenus = null;

        for (GrantedAuthority authority : sysUser.getAuthorities()) {
            if (Constant.ROLE_ADMIN.equals(authority.getAuthority())) {
                //管理员角色返回所有菜单urlCode
                sysMenus = queryList(new TSysMenu());
                return ModelConverUtil.getSubMenu(sysMenus);
            }
            roles.add(authority.getAuthority());
        }
        // 读取用户所拥有权限的所有菜单urlCode
        sysMenus = getAllMenuByRoles(roles);
        return ModelConverUtil.getSubMenu(sysMenus);
    }
}
