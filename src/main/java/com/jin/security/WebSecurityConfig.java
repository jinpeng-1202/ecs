package com.jin.security;

import com.jin.security.exception.AuthenticationAccessDeniedHandler;
import com.jin.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinpeng
 * @date 2019/3/10.
 */
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/v1/api/get/verificationCode", "/static/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //添加转码
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        http.addFilterBefore(encodingFilter, CsrfFilter.class);

        http
                //.addFilterBefore(new MyUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)//未登录

                .and()
                .formLogin().loginProcessingUrl("/v1/login")//登陆入口
                .authenticationDetailsSource(authenticationDetailsSource) //自定义登陆参数
                .successHandler(myAuthenticationSuccessHandler) // 登录成功
                .failureHandler(myAuthenticationFailHander) // 登录失败
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/v1/open/*").permitAll()//过滤不需要鉴权的资源
                .anyRequest().access("@rbacService.hasPermission(request,authentication)"); //必须经过认证以后才能访问

               /* .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();*/

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问 JSON 格式的数据

    }


}
