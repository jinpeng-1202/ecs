package com.jin.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinpeng
 * @date 2019/3/17.
 * 自定义登陆参数
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private String imgCode;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.imgCode = request.getParameter("imgCode");
    }

    public String getImgCode() {
        return imgCode;
    }
}
