package com.jin.threadtest;

/**
 * @author jinpeng
 * @date 2019/5/13.
 */
public class Deadlock {

    private final Object right = new Object();
    private final Object left = new Object();

    public void rightLock() {
        synchronized (right) {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (left) {
                System.out.println("rightLock");
            }
        }
    }

    public void leftLock() {
        synchronized (left) {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (right) {
                System.out.println("leftLock");
            }
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        new Thread(deadlock::leftLock).start();
        new Thread(deadlock::rightLock).start();

        System.out.println(System.identityHashCode(deadlock));
    }
}
