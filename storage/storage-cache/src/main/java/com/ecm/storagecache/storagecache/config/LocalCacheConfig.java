package com.ecm.storagecache.storagecache.config;


import com.ecm.storagecache.storagecache.type.CacheType;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Configuration
public class LocalCacheConfig {

    @Bean(name = "localCacheManager")
    public CacheManager localCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caffeineCaches());

        return cacheManager;
    }

    @Bean
    public List<CaffeineCache> caffeineCaches() {
        return Arrays.stream(CacheType.values())
                .map(cacheType -> {
                    String cacheName = cacheType.getName();
                    Cache<Object, Object> cache = Caffeine.newBuilder()
                            .maximumSize(cacheType.getMaximumSize())
                            .expireAfterWrite(cacheType.getExpireAfterWriteHour(), TimeUnit.HOURS)
                            .recordStats()
                            .build();

                    return new CaffeineCache(cacheName, cache);
                })
                .toList();
    }
}
