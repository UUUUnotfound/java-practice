package com.chengshi.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: tian
 * @date: 2019-01-06 13:46
 */
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisCache redisCache;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        redisCache.setName(s);
        return redisCache;
    }
}
