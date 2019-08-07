package com.jin;

import com.alibaba.fastjson.JSON;
import com.jin.model.TUser;
import com.jin.threadtest.Dish;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author jinpeng
 * @date 2019/4/30.
 */
public class Test {

    public static Integer num = 0;
    public static CountDownLatch end = new CountDownLatch(10);
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> list2 = new LinkedList<>();


    public static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    public static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
    public static ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
    public static AtomicInteger atomicInteger = new AtomicInteger();
    public static AtomicReference<TUser> userAtomicReference = new AtomicReference<>();
    //public static AtomicStampedReference<Integer> integerAtomicStampedReference=new AtomicStampedReference<>();
    public static SynchronousQueue<Integer> integers = new SynchronousQueue<>();
    private static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    //AQS
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    private static ReentrantLock lock=new ReentrantLock();


    public static final Dish dish = new Dish("d1", false, 100, Dish.Type.FISH);

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        System.out.println(16>>4);
    }

    public void a() {
        List<Dish> menu = Arrays.asList(
                new Dish("d1", false, 100, Dish.Type.FISH),
                new Dish("d2", false, 200, Dish.Type.MEAT),
                new Dish("d3", false, 800, Dish.Type.MEAT),
                new Dish("d4", true, 10, Dish.Type.FISH),
                new Dish("d5", false, 500, Dish.Type.OTHER),
                new Dish("d6", true, 600, Dish.Type.OTHER),
                new Dish("d7", false, 50, Dish.Type.OTHER)
        );

        List<Dish> subMuen = null;
        List<String> menuNmae = null;
        menuNmae = menu.stream()
                .filter(dish -> dish.getCalories() >= 300)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(2)
                .distinct()
                .collect(Collectors.toList());

        List<String> strings = Arrays.asList("aa", "sds", "sdsddd", "jin");

        String s = strings.stream()
                .reduce("", (a, b) -> a + "-" + b);

        System.out.println("end " + JSON.toJSONString(s));
    }
}
