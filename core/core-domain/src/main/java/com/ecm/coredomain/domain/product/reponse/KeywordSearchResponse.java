package com.ecm.coredomain.domain.product.reponse;

import com.ecm.coredomain.domain.productgroup.ProductGroupWithProductPreviews;

import java.util.List;

public record KeywordSearchResponse(
        List<ProductGroupWithProductPreviews> productGroupWithProductPreviews
) {
}
