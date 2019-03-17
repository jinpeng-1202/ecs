package com.jin.security.filter;

import com.jin.common.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jinpeng
 * @date 2019/3/17.
 */
public class MyUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    // 是否开启验证码功能
    private boolean isOpenValidateCode = true;

    public MyUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/v1/login", "POST"));
        /*SimpleUrlAuthenticationFailureHandler failedHandler =
                (SimpleUrlAuthenticationFailureHandler)getFailureHandler();
        failedHandler.setDefaultFailureUrl("/user/login.do?validerror");*/
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse)response;

        /*if (!requiresAuthentication(req, res)) {
            chain.doFilter(request, response);
            return;
        }*/
        if (isOpenValidateCode) {
            if(!checkValidateCode(req, res))return;
        }
        chain.doFilter(request,response);
    }

    /**
     * 覆盖授权验证方法，这里可以做一些自己需要的session设置操作
     */
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return null;
    }

    protected boolean checkValidateCode(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionValidateCode = obtainSessionValidateCode(session);
        String validateCodeParameter = obtainValidateCodeParameter(request);
        if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
            unsuccessfulAuthentication(request, response, new InsufficientAuthenticationException("输入的验证码不正确"));
            return false;
        }
        return true;
    }

    private String obtainValidateCodeParameter(HttpServletRequest request) {
        Object obj = request.getParameter(Constant.VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }

    protected String obtainSessionValidateCode(HttpSession session) {
        Object obj = session.getAttribute(Constant.VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }


}
