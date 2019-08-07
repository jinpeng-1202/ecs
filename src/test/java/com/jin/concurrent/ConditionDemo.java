package com.jin.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinpeng
 * @date 2019/8/2.
 */
public class ConditionDemo {

    final static Lock lock = new ReentrantLock();
    final static Condition condition = lock.newCondition();

    private final static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo demo = new ConditionDemo();
        condition.await();

        new Thread(() -> {
            demo.f1();
        }).start();

        new Thread(() -> {
            demo.f1();
        }).start();



        Thread.sleep(7 * 1000);
        new Thread(() -> {
            demo.f2();
        }).start();
    }


    public void f1() {
        synchronized (object) {
            System.out.println(Thread.currentThread() + " enter..");
            try {
                Thread.sleep(2 * 1000);
                System.out.println(Thread.currentThread() + " wait..");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " exit..");
        }
    }

    public void f2() {
        synchronized (object) {
            System.out.println("notify ");
            object.notifyAll();
        }
    }
}
