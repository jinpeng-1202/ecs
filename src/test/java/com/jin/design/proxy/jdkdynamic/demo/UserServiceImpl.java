package com.jin.design.proxy.jdkdynamic.demo;

import com.jin.bean.User;

import java.util.Random;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class UserServiceImpl implements UserService{


    @Override
    public void createUser(User user) {
        System.out.println("create user ");
        int a=new Random().nextInt(10);
        try {
            Thread.sleep(a*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
