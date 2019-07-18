package com.jin.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class Test {

    private static String str = "aaaaaa";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class<?> c = Class.forName("com.jin.reflect.Baaa");
        Object object = c.newInstance();

        Method method = c.getMethod("hand");
        method.invoke(object);

        Method hand2 = c.getMethod("hand2", String.class);
        hand2.invoke(object, "aaaaaaaaa");

        Method hand3 = c.getMethod("hand3", String.class, Integer.class);
        String ret = (String) hand3.invoke(object, "a333", 333);
        System.out.println("object=" + ret);

    }


    public static void sout(Class b) {
        System.out.println(b.getName());
        System.out.println(b.getClass());
        System.out.println(b.getSimpleName());
        System.out.println(b.isInterface());
    }
}
