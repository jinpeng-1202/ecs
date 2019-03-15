package com.jin.security;

import com.alibaba.fastjson.JSON;
import com.jin.bean.ApiResponse;
import com.jin.common.enums.ResCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 用户没有登录时返回给前端的数据
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.getWriter().write(JSON
                .toJSONString(new ApiResponse(ResCode.NOT_LOGIN)));
    }
}
