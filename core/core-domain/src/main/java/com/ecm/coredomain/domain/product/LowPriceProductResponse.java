package com.ecm.coredomain.domain.product;

import java.util.List;

public record LowPriceProductResponse(
        List<ProductInfo> lowPriceProducts
) {
}
