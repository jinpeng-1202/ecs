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
@RequestMapping("/v1/system")
public class SystemController {

    @PostMapping("/menuManage")
    public String menuManage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("menuManage");
        return "系统菜单管理";
    }

    @PostMapping("/userManage")
    public String userManage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("userManage");
        return "userManage";
    }

    @PostMapping("/roleManage")
    public String roleManage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("roleManage");
        return "系统角色管理";
    }

    @PostMapping("/orgManage")
    public String 组织机构管理(HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("orgManage");
        return "组织机构管理";
    }
}
