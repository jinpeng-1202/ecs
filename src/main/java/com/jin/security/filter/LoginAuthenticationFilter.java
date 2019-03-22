package com.jin.security.filter;

import com.jin.common.Constant;
import com.jin.security.exception.MyAuthenticationFailHander;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jinpeng
 * @date 2019/3/22.
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public LoginAuthenticationFilter() {
        AntPathRequestMatcher requestMatcher =
                new AntPathRequestMatcher("/v1/login", "POST");
        this.setRequiresAuthenticationRequestMatcher(requestMatcher);
        this.setAuthenticationManager(getAuthenticationManager());
        this.setAuthenticationFailureHandler(new MyAuthenticationFailHander());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String imgCode = request.getParameter(Constant.VALIDATE_CODE);
        String sessionImgCode = (String) request.getSession().getAttribute(Constant.VALIDATE_CODE);

        System.out.println("imgCode= " + imgCode);
        System.out.println("sessionImgCode= " + sessionImgCode);

        if (StringUtils.isBlank(sessionImgCode)
                || !sessionImgCode.equalsIgnoreCase(imgCode)) {
            throw new BadCredentialsException("验证码错误!");
        }
        return super.attemptAuthentication(request, response);
    }

}
