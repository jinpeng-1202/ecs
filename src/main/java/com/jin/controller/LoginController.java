package com.jin.controller;

import com.alibaba.fastjson.JSON;
import com.jin.bean.ApiResponse;
import com.jin.bean.LoginReq;
import com.jin.bean.SubMenu;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author jinpeng
 * @date 2019/3/13.
 */
@RestController
@RequestMapping("/v1/api")
public class LoginController {

    private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int NUMBER_OF_CHS = 4;
    private static final int IMG_WIDTH = 65;
    private static final int IMG_HEIGHT = 25;
    private static Random r = new Random();

    @GetMapping("/get/verificationCode")
    public void verificationCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 实例化BufferedImage
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // 验证码图片的背景颜色
        Color c = new Color(200, 200, 255);
        g.setColor(c);
        // 图片的边框
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);

        // 用于保存验证码字符串
        StringBuffer sb = new StringBuffer();
        int index;
        for (int i = 0; i < NUMBER_OF_CHS; i++) {
            // 随机一个下标
            index = r.nextInt(chs.length);
            // 随机一个颜色
            g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));
            // 画出字符
            g.drawString(chs[index] + "", 15 * i + 3, 18);
            // 验证码字符串
            sb.append(chs[index]);
        }

        // 将验证码字符串保存到session中
        request.getSession().setAttribute("piccode", sb.toString());
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginReq loginReq, HttpServletRequest request) throws Exception {
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
