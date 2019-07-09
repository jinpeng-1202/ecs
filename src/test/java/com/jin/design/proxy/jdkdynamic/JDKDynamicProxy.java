package com.jin.design.proxy.jdkdynamic;

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
        System.out.println("do something before ..");
        Object result = method.invoke(target, args);
        System.out.println("do something after ..");
        return result;
    }


    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        Subject subject=new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.dosomething();
    }
}
