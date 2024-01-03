package com.ecm.coredomain.domain.productgroup;

import com.ecm.coredomain.domain.search.KeywordSearcher;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class ProductGroupSearcher {

    private final KeywordSearcher keywordSearcher;

    @Cacheable(cacheNames = "KEYWORD", key = "#keyword", unless = "#result.size() == 0", cacheResolver = "cacheResolver")
    public List<ProductGroup> execute(
            String keyword,
            Integer size
    ) {
        System.out.println("[LOCAL] NO CACHING");
        return keywordSearcher.findByKeyword(keyword, size);
    }
}
