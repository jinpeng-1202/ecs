package com.jin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */
@RestController
@RequestMapping("/v1/api")
public class TestController {


    @GetMapping("/test")
    public String test() {
        Long a=System.currentTimeMillis();
        System.out.println("time= "+a);
        return "小juju 520 0_0 ";
    }


}
