package com.jin.annotation;

import java.lang.reflect.Method;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class UserCaseUtil {

    public static void main(String[] args) {
        Class c = AnnoTest.class;
        for (Method method : c.getMethods()) {
            UserCase userCase = method.getAnnotation(UserCase.class);

        }
    }

}
