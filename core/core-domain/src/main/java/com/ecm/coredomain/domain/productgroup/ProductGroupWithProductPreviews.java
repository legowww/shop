package com.ecm.coredomain.domain.productgroup;

import com.ecm.coredomain.domain.product.ProductPreview;

import java.util.List;

public record ProductGroupWithProductPreviews(
        ProductGroup productGroup,
        List<ProductPreview> productPreviews
) {
}
