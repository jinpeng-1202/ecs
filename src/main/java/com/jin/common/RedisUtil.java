package com.jin.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;

/**
 * @author jinpeng
 * @date 2019/4/23.
 */
@Configuration
public class RedisUtil {

    @Bean
    public RedisTemplate redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public ValueOperations<String,String> strings() {
        return redisTemplate.opsForValue();
    }

    public ListOperations list() {
        return redisTemplate.opsForList();
    }

    public SetOperations set() {
        return redisTemplate.opsForSet();
    }

    public ZSetOperations<String,String> zSet() {
        return redisTemplate.opsForZSet();
    }

    public HashOperations<String,String,Object> hash() {
        return redisTemplate.opsForHash();
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

}
