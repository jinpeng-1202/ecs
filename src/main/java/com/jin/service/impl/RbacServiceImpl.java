package com.jin.service.impl;

import com.alibaba.fastjson.JSON;
import com.jin.common.Constant;
import com.jin.model.TSysMenu;
import com.jin.service.RbacService;
import com.jin.service.TSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private TSysMenuService menuService;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        boolean hasPermission = false;

        System.out.println("********** getPrincipal=" + JSON.toJSONString(authentication.getPrincipal()));
        Object object = authentication.getPrincipal();
        if (object instanceof String) {
            if (Constant.ANONYMOUS_USER.equalsIgnoreCase((String) object)) {
                return hasPermission;
            }
        } else if (object instanceof UserDetails) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            String userName = principal.getUsername();

            List<String> roles = new ArrayList<>();
            for (GrantedAuthority authority : principal.getAuthorities()) {
                if (Constant.ROLE_ADMIN.equals(authority.getAuthority())) {
                    return true;
                }
                roles.add(authority.getAuthority());
            }
            //读取用户所拥有权限的所有URL
            List<TSysMenu> urls = menuService.getAllMenuByRoles(roles);

            // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
            for (TSysMenu menu : urls) {
                System.out.println("getRequestURI= " + request.getRequestURI());
                System.out.println("getUrl= " + menu.getUrl());
                if (antPathMatcher.match(menu.getUrl(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }

}
