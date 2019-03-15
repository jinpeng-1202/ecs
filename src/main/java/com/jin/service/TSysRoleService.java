package com.jin.service;


import com.jin.base.BaseService;
import com.jin.model.TSysRole;

import java.util.List;

public interface TSysRoleService  extends BaseService<TSysRole>   {

    List<TSysRole> queryRolesByUid(Long uid);


}
