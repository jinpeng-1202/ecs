package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.bean.SysUser;
import com.jin.model.TSysUser;
import com.jin.service.TSysRoleService;
import com.jin.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TSysUserServiceImpl extends BaseServiceImpl<TSysUser>  implements TSysUserService {

    @Autowired
    private TSysRoleService roleService;

    @Override
    public SysUser queryUserByName(String username) {
        SysUser user=new SysUser();
        user.setId(1L);
        user.setUsername("jinp");
        user.setPassword("123456");
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setRoles(roleService.queryRolesByUid(user.getId()));
        return user;
    }
}
