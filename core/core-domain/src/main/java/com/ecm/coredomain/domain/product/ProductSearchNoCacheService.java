package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.product.reponse.KeywordSearchResponse;
import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupWithProductPreviews;
import com.ecm.coredomain.domain.search.KeywordSearcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductSearchNoCacheService {

    private final KeywordSearcher keywordSearcher;
    private final ProductRepository productRepository;

    public KeywordSearchResponse keywordSearch(
            String keyword
    ) {
        log.info("[ProductSearchNoCacheService] 호출");
        List<ProductGroup> productGroups = keywordSearcher.findByKeyword(keyword, 10);
        List<ProductGroupWithProductPreviews> result = productGroups.stream()
                .map(productGroup -> {
                            List<ProductPreview> productPreviews = productRepository.findLowPriceProducts(productGroup.id(), 5);
                            return new ProductGroupWithProductPreviews(productGroup, productPreviews);
                        }
                ).toList();

        return new KeywordSearchResponse(result);
    }
}
