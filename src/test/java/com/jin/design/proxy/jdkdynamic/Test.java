package com.jin.design.proxy.jdkdynamic;

import com.jin.bean.User;
import com.jin.design.proxy.jdkdynamic.demo.UserService;
import com.jin.design.proxy.jdkdynamic.demo.UserServiceImpl;

/**
 * @author jinpeng
 * @date 2019/7/3.
 */
public class Test {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService service = new JDKDynamicProxy(new UserServiceImpl()).getProxy();
        User user = new User();
        user.setName("jinp");
        service.createUser(user);
    }
}
