package com.ecm.storagecache.storagecache.local.scheduler;

import com.ecm.coredomain.domain.search.KeywordSearcher;
import com.ecm.storagecache.storagecache.local.config.LocalCacheType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;

@Slf4j
@RequiredArgsConstructor
@Component
public class KeywordCacheScheduler {

    private final CacheManager cacheManager;
    private final KeywordSearcher keywordSearcher;

    //오전 6시
    @Scheduled(cron = "0 0 6 * * ?")
    public void execute() {
        Cache keywordCache = cacheManager.getCache(LocalCacheType.KEYWORD.name());
        com.github.benmanes.caffeine.cache.Cache<Object, Object> cache = (com.github.benmanes.caffeine.cache.Cache<Object, Object>) keywordCache.getNativeCache();

        ConcurrentMap<Object, Object> map = cache.asMap();
        for (Object o : map.keySet()) {
            String keyword = String.valueOf(o);
            keywordCache.put(keyword, keywordSearcher.findByKeyword(keyword, 10));
        }
    }
}
