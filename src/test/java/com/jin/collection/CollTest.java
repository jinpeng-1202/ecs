package com.jin.collection;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jinpeng
 * @date 2019/8/2.
 */
public class CollTest {

    //队列实现
    LinkedList<String> linkedList;
    ConcurrentLinkedQueue concurrentLinkedQueue;
    LinkedBlockingQueue blockingQueue;
    ArrayBlockingQueue arrayBlockingQueue;

    //list
    ArrayList arrayList;

    //map
    HashMap hashMap;
    ConcurrentHashMap concurrentHashMap;

    Set set=new HashSet();

    public static void main(String[] args) {
        System.out.println(20>>1);
    }
}
