package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupWithProductPreviews;
import com.ecm.coredomain.domain.productgroup.ProductSearcher;
import com.ecm.coredomain.domain.product.reponse.KeywordSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductSearchService {

    private final ProductSearcher productSearcher;

    public KeywordSearchResponse keywordSearch(
            String keyword
    ) {
        List<ProductGroup> productGroups = productSearcher.searchGroups(keyword, 10);
        List<ProductGroupWithProductPreviews> productGroupWithProductPreviews = productSearcher.searchProducts(productGroups);

        return new KeywordSearchResponse(productGroupWithProductPreviews);
    }
}
