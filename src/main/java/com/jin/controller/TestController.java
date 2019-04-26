package com.jin.controller;

import com.jin.common.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */
@RestController
@RequestMapping("/v1/open")
public class TestController {


    @GetMapping("/test")
    public String test(HttpServletResponse response, HttpServletRequest request) throws Exception {
        test();
        return "试试sss";

    }

    @Autowired
    private RedisUtil redisUtil;

    public void test() throws Exception {
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    redisUtil.strings().set("ecs-" + finalI, "value-" + finalI,10, TimeUnit.SECONDS);
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
