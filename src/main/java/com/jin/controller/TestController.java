package com.jin.controller;

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
@RequestMapping("/v1/api")
public class TestController {


    @GetMapping("/test")
    public void test(HttpServletResponse response, HttpServletRequest request) throws IOException {


    }



}
