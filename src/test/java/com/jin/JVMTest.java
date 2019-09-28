package com.jin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jinpeng
 * @date 2019/8/28.
 */
public class JVMTest {

    private static int count = 0;

    public static void main(String[] args) {
        JVMTest test = new JVMTest();

        try {
            test.heapOutOfMemory();
        } catch (Throwable t) {
            System.out.println("count=" + count);
            throw t;
        }
    }

    public void stringOOM(){
        List<String> list=new ArrayList<>();
        while (true){
            list.add(""+new Random().nextInt());
        }
    }

    public void stackOutOfMemory() {
        while (true) {
            new Thread(() -> {
                doSomething();
            }).start();
        }
    }

    public void stackLeak() {
        count++;
        stackLeak();
    }

    public void heapOutOfMemory() {
        System.out.println("aa");
        List list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }


    public static void doSomething() {
        while (true) {
        }
    }
}
