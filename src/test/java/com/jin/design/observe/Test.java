package com.jin.design.observe;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public class Test {
    public static void main(String[] args) {
        Observer o1 = new StudentObserver();
        Observer o2 = new StudentObserver();

        TeacherSubject subject = new TeacherSubject();
        subject.addObserver(o1);
        subject.addObserver(o2);

        subject.setHomework("语文题100");
        subject.notifyObserver();

        subject.setHomework("数学题100");
        subject.notifyObserver();
    }
}
