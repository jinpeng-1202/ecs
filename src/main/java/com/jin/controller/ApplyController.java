package com.jin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2019/3/16.
 */
@RestController
@RequestMapping("/v1/apply")
public class ApplyController {

    @PostMapping("/userInfo")
    public String userInfo(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("userInfo");
        request.getCookies();
        return "用户信息查询";
    }

    @PostMapping("/applyInfoQuery")
    public String applyInfoQuery(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("applyInfoQuery");
        return "进件信息查询";
    }

    @PostMapping("/preApprovalQuery")
    public String preApprovalQuery(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("userInfo");
        return "预授信信息查询";
    }
    @PostMapping("/assetCallbackMessage")
    public String assetCallbackMessage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("userInfo");
        return "未处理的资管回调消息";
    }
    @PostMapping("/querySmsCode")
    public String menuManage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("querySmsCode");
        return "验证码查询";
    }

}
