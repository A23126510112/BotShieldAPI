package com.example.botshieldapi.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ListIterator;
import java.util.Set;

@Service
public class RedisService {
    private RedisTemplate<String,String> redisTemplate;
    public RedisService(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void increment(String key,long value){
        redisTemplate.opsForValue().increment(key, value);
    }
    public long get(String key){
        String value = redisTemplate.opsForValue().get(key);
        return value == null ? 0 : Long.parseLong(value);
    }
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void setWithTTL(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }
    public void updateLeaderboard(Long postId, double score) {
        redisTemplate.opsForZSet()
                .incrementScore("post:leaderboard", postId.toString(), score);
    }
    public Set<ZSetOperations.TypedTuple<String>> getTopPosts(int limit) {
        return redisTemplate.opsForZSet()
                .reverseRangeWithScores("post:leaderboard", 0, limit - 1);
    }
}
