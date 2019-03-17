package com.jin.controller;

import com.jin.common.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author jinpeng
 * @date 2019/3/15.
 * 不用登陆可以获取的资源
 */
@RestController
@RequestMapping("/v1/open")
public class OpenController {

    private static char[] chs = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789".toCharArray();
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
        Color c = new Color(255, 252, 117);
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
        request.getSession().setAttribute(Constant.VALIDATE_CODE, sb.toString());
        ImageIO.write(image, "jpg", response.getOutputStream());

    }
}
