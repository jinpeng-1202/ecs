package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.bean.SysUser;
import com.jin.model.TSysUser;
import com.jin.service.TSysRoleService;
import com.jin.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
@Service
public class TSysUserServiceImpl extends BaseServiceImpl<TSysUser>  implements TSysUserService {

    @Autowired
    private TSysRoleService roleService;

    @Override
    public SysUser queryUserByName(String username) {
        TSysUser sysUser=new TSysUser();
        sysUser.setUsername(username);
        sysUser=queryObj(sysUser);
        if(sysUser==null){
            throw new BadCredentialsException("用户名不存在");
        }
        return new SysUser(sysUser,roleService.queryRolesByUid(sysUser.getId()));
    }
}
