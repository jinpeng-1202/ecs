package com.jin.controller;

import com.jin.common.RedisUtil;
import com.jin.service.impl.TCommAreaServiceImpl;
import com.jin.service.impl.TDataDictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */
@RestController
@RequestMapping("/v1/open")
public class TestController {

    @Autowired
    TDataDictServiceImpl dataDictService;
    @Autowired
    private TCommAreaServiceImpl commAreaService;


    @PostMapping("/test")
    public String test(HttpServletResponse response, HttpServletRequest request) throws Exception {

        for (Map.Entry<Thread, StackTraceElement[]> itme : Thread.getAllStackTraces().entrySet()) {
            Thread thread = itme.getKey();
            StackTraceElement[] elements = itme.getValue();
            for (StackTraceElement e : elements) {
                System.out.println(thread.currentThread() + "    element= " + e);
            }
        }

        return "试试sss";
    }

    @PostMapping("/test2")
    public String test2(@RequestParam Integer num, HttpServletResponse response, HttpServletRequest request) throws Exception {
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            list.add(new OOMTest());
            Thread.sleep(10 * 1000);
        }
        return "success";
    }

    static class OOMTest {

        public byte[] bytes = new byte[10 * 1024 * 1024];
    }

    @PostMapping("/test3")
    public String test3(@RequestParam Integer num, HttpServletResponse response, HttpServletRequest request) throws Exception {

        new Thread(() -> {
            dataDictService.data();
        }).start();

        new Thread(() -> {
            commAreaService.com1();
        }).start();

        return "success";
    }

    @PostMapping("/test4")
    public void test4(@RequestParam Integer num, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("aa");
        List list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }



    @Autowired
    private RedisUtil redisUtil;

    public void test() throws Exception {
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    redisUtil.strings().set("ecs-" + finalI, "value-" + finalI, 10, TimeUnit.SECONDS);
                    System.out.println("aaaaaaaaaaaaaa+" + finalI);
                }
            }).start();
        }

    }


    @RequestMapping("/whoim")
    public Object whoIm() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
