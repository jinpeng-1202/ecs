package com.jin.design.proxy.jdkdynamic;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jinpeng
 * @date 2019/7/3.
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:" + proxy.getClass() + " method:" + method.getName() +
                " agrs:" + JSON.toJSONString(args));

        Long startTime = System.currentTimeMillis();
        System.out.println("before time:" + startTime);
        Object result = method.invoke(target, args);
        Long endTime = System.currentTimeMillis();
        System.out.println(" handTime:" + ((endTime - startTime) / 1000) + "s");
        return result;
    }


    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}
