package com.ecm.coredomain.domain.productgroup;

import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.coredomain.domain.productgroup.ProductGroup;

import java.util.List;

public record ProductGroupWithProductPreviews(
        ProductGroup productGroup,
        List<ProductPreview> productPreviews
) {
}
