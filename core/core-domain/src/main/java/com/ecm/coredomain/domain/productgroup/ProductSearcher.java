package com.ecm.coredomain.domain.productgroup;

import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.coredomain.domain.product.ProductReader;
import com.ecm.coredomain.domain.search.KeywordSearcher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
@Transactional(readOnly = true)
public class ProductSearcher {

    private static final Logger log = LoggerFactory.getLogger("file");
    private final ProductReader productReader;
    private final KeywordSearcher keywordSearcher;

    @Cacheable(cacheNames = "KEYWORD", key = "#keyword", unless = "#result.size() == 0")
    public List<ProductGroup> searchGroups(
            String keyword,
            Integer size
    ) {
        log.info("[ProductSearcher:searchGroups] [Use DB Data] KEYWORD={}", keyword);
        return keywordSearcher.findByKeyword(keyword, size);
    }

    public List<ProductGroupWithProductPreviews> searchProducts(
            List<ProductGroup> productGroups
    ) {
        return productGroups.stream()
                .map(productGroup -> {
                            List<ProductPreview> productPreviews = productReader.readLowPriceProducts(productGroup.id(), 5);
                            return new ProductGroupWithProductPreviews(productGroup, productPreviews);
                        }
                ).toList();
    }
}
