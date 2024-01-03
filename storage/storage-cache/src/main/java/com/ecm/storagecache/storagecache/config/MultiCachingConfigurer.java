package com.ecm.storagecache.storagecache.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Configuration
@EnableCaching
public class MultiCachingConfigurer implements CachingConfigurer {
    
    private final CacheManager localCacheManager;
    private final CacheManager globalCacheManager;
    
    @Bean
    @Override
    public CacheResolver cacheResolver() {
        return new CacheResolver() {
            @Override
            public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
                Collection<Cache> caches = new ArrayList<>();

                if ("execute".equals(context.getMethod().getName())) {
                    caches.add(localCacheManager.getCache("KEYWORD"));
                } else {
                    caches.add(globalCacheManager.getCache("PRODUCT_GROUP"));
                }
                
                return caches;
            }
        };
    }
}
