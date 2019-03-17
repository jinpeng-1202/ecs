package com.jin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */
@RestController
@RequestMapping("/v1/open")
public class TestController {


    @GetMapping("/test")
    public String test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("test test");
        return "试试sss";

    }



    @RequestMapping("/whoim")
    public Object whoIm(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }



}
