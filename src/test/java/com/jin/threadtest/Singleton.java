package com.jin.threadtest;

/**
 * @author jinpeng
 * @date 2019/5/7.
 */
public class Singleton {

    /*private static Singleton singleton1 = new Singleton();
    private static Singleton singleton2 = null;*/
    private static Singleton singleton3 = null;

    public Singleton() {
        System.out.println("******Singleton init");
    }

    //1
    /*public static Singleton getSingleton1() {
        return singleton1;
    }

    //2
    public static synchronized Singleton getSingleton2() {
        if (singleton2 == null)
            singleton2 = new Singleton();
        return singleton2;
    }*/

    //3
    private static class SingletonHolder {
        public SingletonHolder(){
            System.out.println("******SingletonHolder init");
        }
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton3() {
        return SingletonHolder.singleton;
    }


}
