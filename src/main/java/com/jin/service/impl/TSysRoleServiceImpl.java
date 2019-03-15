package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.model.TSysRole;
import com.jin.service.TSysRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TSysRoleServiceImpl extends BaseServiceImpl<TSysRole>  implements TSysRoleService {

    @Override
    public List<TSysRole> queryRolesByUid(Long uid) {
        List<TSysRole> roles = new ArrayList<>();
        TSysRole role = new TSysRole();
        role.setId(1L);
        role.setRoleName("ROLE_ADMIN");
        roles.add(role);
        return roles;
    }
}
