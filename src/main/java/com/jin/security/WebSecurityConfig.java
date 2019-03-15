package com.jin.security;

import com.jin.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

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
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private AuthenticationAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

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
        web.ignoring().antMatchers("/v1/api/get/verificationCode", "/static/**");
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and().formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .failureHandler(myAuthenticationFailHander)
                .successHandler(myAuthenticationSuccessHandler)
                .and().logout().permitAll()
                .and().csrf().disable().exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()

                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .authorizeRequests()
                .antMatchers("/v1/api/test").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated(); // 其他 url 需要身份认证

                /*.and()
                .formLogin()  //开启登录
                .successHandler(myAuthenticationSuccessHandler) // 登录成功
                .failureHandler(myAuthenticationFailHander) // 登录失败
                .permitAll();*/

               /* .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();*/

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问 JSON 格式的数据

    }


    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .accessDeniedHandler(new GoAccessDeniedHandler())
                .authenticationEntryPoint(new GoAuthenticationEntryPoint())
                .and().authorizeRequests()
                .antMatchers("/", "/csrf").permitAll()
                .antMatchers("/hello").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(new GoAuthenticationSuccessHandler())
                .failureHandler(new GoAuthenticationFailureHandler())
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new GoLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().requiresChannel()
                .antMatchers("/pomer").requiresSecure()
                .anyRequest().requiresInsecure()
                .and().rememberMe()
                .tokenValiditySeconds(1800)
                .key("token_key");
    }*/


}
