package com.jin.service.impl;

import com.jin.bean.SysUser;
import com.jin.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jinpeng
 * @date 2019/3/10.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TSysUserService userService;

    /**
     * 加载用户
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user = userService.queryUserByName(s);

        return user;
    }
}
