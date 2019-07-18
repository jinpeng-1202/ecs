package com.jin.design.proxy.jdkdynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class HelloMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置处理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置处理");
        return result;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        Hello hello = (Hello) enhancer.create();
        hello.hello();
    }
}
