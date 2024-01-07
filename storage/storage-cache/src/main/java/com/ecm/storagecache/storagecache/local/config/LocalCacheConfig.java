package com.ecm.storagecache.storagecache.local.config;


import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Configuration
public class LocalCacheConfig {

    @Primary
    @Bean(name = "localCacheManager")
    public CacheManager localCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine());

        return caffeineCacheManager;
    }

    @Bean
    public Caffeine caffeine() {
        return Caffeine.newBuilder()
                .maximumSize(LocalCacheType.KEYWORD.getMaximumSize())
                .expireAfterAccess(LocalCacheType.KEYWORD.getRefreshAfterWriteHour(), TimeUnit.HOURS);
    }
}
