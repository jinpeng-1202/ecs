package com.jin.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinpeng
 * @date 2019/4/28.
 */
public class LockUtil {

    String LOCK = "lock";

    @Autowired
    private RedisUtil redisUtil;

    private ThreadLocal<Map<String, String>> currThreadMap = new ThreadLocal<>();

    public boolean lock(String key) {
        Map<String, String> currentMap = new HashMap<>();
        Integer milliSecond = 10;
        // 系统当前毫秒数
        Long currTime = System.currentTimeMillis();
        Long expireTime = currTime + new Long(milliSecond);
        boolean isAbsent = redisUtil.strings().setIfAbsent(key, expireTime + "");
        if (isAbsent) {
            System.out.println("防重校验通过，不是重复提交!");
            currentMap.put(LOCK, key);
        } else {
            System.out.println("防重校验失败，是重复提交，需校验超时时间!");
            String cacheExpTime = redisUtil.strings().get(key);
            if (StringUtils.isNotEmpty(cacheExpTime)) {
                if (currTime > Long.valueOf(cacheExpTime)) {
                    System.out.println("redis锁已超时，当前请求可以重新获取锁，currTime={}, cacheExpTime={}");
                    Long newExpTime = System.currentTimeMillis() + new Long(milliSecond);
                    String oldExpTime = redisUtil.strings().getAndSet(key, newExpTime.toString());
                    if (!cacheExpTime.equals(oldExpTime)) {
                        System.out.println("锁已经被其他线程获取，当前线程拒绝执行请求");
                        return false;
                    }
                    System.out.println("当前线程已经获得锁，可以执行请求");
                    currentMap.put(LOCK, key);
                } else {
                    System.out.println("redis锁未超时，当前请求拒绝执行，currTime={}, cacheExpTime={}");
                    return false;
                }
            } else {
                System.out.println("redis缓存时间为空，锁已解除,重新获取锁");
                expireTime = currTime + new Long(milliSecond);
                boolean isAbsent2 = redisUtil.strings().setIfAbsent(key, expireTime.toString());
                if (isAbsent2) {
                    System.out.println("锁已经被其他线程获取，当前线程拒绝执行请求");
                    return false;
                }
                System.out.println("当前线程已经获得锁，可以执行请求");
                currentMap.put(LOCK, key);
            }
        }
        return false;
    }
}
