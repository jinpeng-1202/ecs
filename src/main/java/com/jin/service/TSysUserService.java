package com.jin.service;


import com.jin.base.BaseService;
import com.jin.bean.SysUser;
import com.jin.model.TSysUser;
public interface TSysUserService  extends BaseService<TSysUser>   {

    SysUser queryUserByName(String username);


}
