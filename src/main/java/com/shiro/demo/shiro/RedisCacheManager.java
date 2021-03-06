package com.shiro.demo.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Redis缓存管理器，使用Redis做Session缓存支持
 * 注意，集群环境下，不需要配置RedisCache，请直接使用RedisSessionDao，这里代码保留仅做学习参考和演示使用
 * 该配置建议在在单机环境下做Session持久化时用，另外配置了RedisSessionDao之后也不需要配置这个，建议优先使用RedisSessionDao
 * Shiro默认将Session保存在内存中的，重启后Session会消失，导致重启后所有用户登录状态丢失
 * 那么这时候就需要将Session持久化了，最好的归宿当然是放在Redis
 *
 * @author zhangkuan
 * @date 2019/8/8
 */
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }

}
