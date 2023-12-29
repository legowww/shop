package com.ecm.coredomain.domain.product;

import com.ecm.coredomain.domain.productgroup.ProductGroup;

import java.util.List;

public record ProductGroupMainLowPriceProduct(
        ProductGroup productGroup,
        List<ProductInfo> productInfos
) {
}
