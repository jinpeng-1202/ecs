package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.model.TSysRole;
import com.jin.service.TSysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSysRoleServiceImpl extends BaseServiceImpl<TSysRole> implements TSysRoleService {

    @Override
    public List<TSysRole> queryRolesByUid(Long uid) {

        return getListBySqlId("getRolesByUID", uid, new TSysRole());
    }


}
