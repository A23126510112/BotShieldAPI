package com.example.botshieldapi.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ListIterator;

@Service
public class RedisService {
    private RedisTemplate<String,Long> redisTemplate;
    public RedisService(RedisTemplate<String,Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void increment(String key,long value){
        redisTemplate.opsForValue().increment(key, value);
    }
    public long get(String key){
        Long val=redisTemplate.opsForValue().get(key);
        return val==null?0:val;
    }
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void setWithTTL(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key, Long.valueOf(value), duration);
    }
}
