package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jinpeng
 * @date 2018/12/28.
 */

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(value = {"com.jin"})
@PropertySource(value = {"classpath:application-${spring.profiles.active}.properties"})
public class EcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcsApplication.class, args);
    }
}
