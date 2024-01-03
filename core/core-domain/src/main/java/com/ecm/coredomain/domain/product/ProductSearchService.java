package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupWithProductPreviews;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearcher;
import com.ecm.coredomain.domain.product.reponse.KeywordSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductSearchService {

    private final ProductReader productReader;
    private final ProductGroupSearcher productGroupSearcher;

    public KeywordSearchResponse keywordSearch(
            String keyword
    ) {
        List<ProductGroup> productGroups = productGroupSearcher.execute(keyword, 10);
        List<ProductGroupWithProductPreviews> result = productGroups.stream()
                .map(productGroup -> {
                    List<ProductPreview> productPreviews = productReader.readLowPriceProducts(productGroup.id(), 5);
                    return new ProductGroupWithProductPreviews(productGroup, productPreviews);
                })
                .toList();

        return new KeywordSearchResponse(result);
    }
}
