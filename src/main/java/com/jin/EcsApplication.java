package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */

@SpringBootApplication
@EnableConfigurationProperties
//@PropertySource(value = "classpath:config/${spring.profiles.active}/application.properties")
public class EcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcsApplication.class, args);
    }
}
