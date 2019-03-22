package com.jin.security.exception;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jin.bean.ApiResponse;
import com.jin.common.enums.ResCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        System.out.println("***************************");
        /*System.out.println(request.getSession().getAttribute(Constant.VALIDATE_CODE));
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        System.out.println(JSON.toJSON(details.getImgCode()));*/

        response.getWriter().write(JSON
                .toJSONString(new ApiResponse(ResCode.SUCCESS)));
    }

}
