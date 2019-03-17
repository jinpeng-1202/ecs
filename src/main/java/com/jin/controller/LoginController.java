package com.jin.controller;

import com.alibaba.fastjson.JSON;
import com.jin.bean.ApiResponse;
import com.jin.bean.LoginReq;
import com.jin.bean.SubMenu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author jinpeng
 * @date 2019/3/13.
 */
@RestController
@RequestMapping("/v1")
public class LoginController {


    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginReq loginReq, HttpServletRequest request) throws Exception {
        System.out.println("login************** "+JSON.toJSON(loginReq));
        ApiResponse res = new ApiResponse();
        System.out.println(JSON.toJSONString(loginReq));
        String str = (String) request.getSession().getAttribute("piccode");
        if (!loginReq.getImgCode().equalsIgnoreCase(str)) {
            res.setCode(999);
            res.setMessage("error");
        }
        return res;
    }



    @PostMapping("/system/loadUserMenu")
    public ApiResponse loadUserMenu(HttpServletRequest request) throws Exception {
        ApiResponse res = new ApiResponse();

        res.setData(getMenu());

        System.out.println(JSON.toJSONString(res));

        return res;
    }


    private static java.util.List<SubMenu> getMenu() {

        java.util.List<SubMenu> subMenus = new ArrayList<>();

        SubMenu subMenu=new SubMenu();
        subMenu.setId("1e2ac76b08914dbe8b36ef82ad189a7a");
        subMenu.setName("系统管理");
        subMenu.setOpen("true");
        subMenu.setUrlCode("systerm");
        subMenu.setParentId("-1");


        SubMenu subMenu1=new SubMenu();
        subMenu1.setId("613b6a624a424485b8e086f671948b81");
        subMenu1.setName("重置合同状态");
        subMenu1.setOpen("true");
        subMenu1.setUrlCode("resetContractStatus");
        subMenu1.setParentId("1e2ac76b08914dbe8b36ef82ad189a7a");

        SubMenu subMenu2=new SubMenu();
        subMenu2.setId("633bac5e4d5843e99ef938bea9f4cdbd");
        subMenu2.setName("个人密码修改");
        subMenu2.setOpen("true");
        subMenu2.setUrlCode("changePassword");
        subMenu2.setParentId("1e2ac76b08914dbe8b36ef82ad189a7a");

        java.util.List<SubMenu> subMenus1 = new ArrayList<>();
        subMenus1.add(subMenu1);
        subMenus1.add(subMenu2);
        subMenu.setSubMenu(subMenus1);
        subMenus.add(subMenu);

        return subMenus;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(getMenu()));
    }

}
