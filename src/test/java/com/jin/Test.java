package com.jin;

import com.alibaba.fastjson.JSON;
import com.jin.model.TUser;
import com.jin.threadtest.Dish;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author jinpeng
 * @date 2019/4/30.
 */
public class Test implements Serializable {

    public static Integer num = 0;
    public static CountDownLatch end = new CountDownLatch(10);
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> list2 = new LinkedList<>();

    public static HashMap hashMap = new HashMap();
    public static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    public static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
    public static ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static AtomicInteger atomicInteger = new AtomicInteger();
    public static AtomicReference<TUser> userAtomicReference = new AtomicReference<>();
    //public static AtomicStampedReference<Integer> integerAtomicStampedReference=new AtomicStampedReference<>();
    public static SynchronousQueue<Integer> integers = new SynchronousQueue<>();
    private static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    //AQS
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    private static ReentrantLock lock = new ReentrantLock();

    static final String ss = "a";
    private volatile static int count = 0;
    public static final Dish dish = new Dish("d1", false, 100, Dish.Type.FISH);

    public static void main(String[] args) throws Exception {
        String url="http://www.bai.com/dfsfdffd?a=b&c=fddfdf#dfdsfdssssssssssssssssssssssssssdfdfdsfdsfdfdfdfdfdsfdfsdfsfsdfsdfsdfsdfdfdsfdsfdsfwerfhgjgjdsfcxvzxvfdhfdhdssdcsdfds" +
                "fdfdshfsfdsfkdlllllllllllllllldfdfdfdfdfsdf{dfdfd}";
        checkUrl(url);
    }

    public final static String REGEX_URL = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";

    public static void checkUrl(String url) throws Exception {
        Pattern pattern = Pattern.compile(REGEX_URL);
        if (!pattern.matcher(url).matches()) {
            throw new Exception("url格式有误");
        }else {
            System.out.println("url success");
        }
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
