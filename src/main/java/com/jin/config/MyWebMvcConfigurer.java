package com.jin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/11.
 */
@Configuration
@EnableWebMvc
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
                .addMapping("/**")
                //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
                .allowedOrigins("*")
                //允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true)
                //允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
                .allowedHeaders("*");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(getObjectMapper());
        return converter;
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //解决中文乱码
        converters.add(responseBodyConverter());
        //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
        converters.add(messageConverter());
    }

    /*@Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置中文编码格式
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        list.add(MediaType.ALL);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }*/



}
