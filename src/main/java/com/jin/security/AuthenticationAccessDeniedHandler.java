package com.jin.security;

import com.alibaba.fastjson.JSON;
import com.jin.bean.ApiResponse;
import com.jin.common.enums.ResCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2019/3/10.
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 无权访问
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.getWriter().write(JSON
                .toJSONString(new ApiResponse(ResCode.NEEd_AUTHORITIES)));
    }

}
