package com.jin.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dengfu on 2017/8/16.
 * 线程池工具类
 */
public class ThreadPoolUtil {

    /**
     * 单线程池，使用地方：
     *     发送短信
     *     记录登录日志
     */
    public static ExecutorService commonPool = Executors.newFixedThreadPool(8);

    /**
     * 查询核心合同信息
     */
    public static ExecutorService queryCorePool = Executors.newFixedThreadPool(8);

    /**
     * 单线程池，使用地方：
     *     记录系统请求信息
     */
    public static ExecutorService signThreadPool = Executors.newSingleThreadExecutor();

    /**
     * 单线程池，使用地方：
     *    记录资管回调消息
     */
    public static ExecutorService assetExecuteSignPool = Executors.newSingleThreadExecutor();

    /**
     * 资管推送注册用户
     */
    public static ExecutorService userPool = Executors.newFixedThreadPool(2);
}
