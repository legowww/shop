package com.ecm.coredomain.domain.product.reponse;

import com.ecm.coredomain.domain.product.ProductWithShop;

public record ProductResponse(
        Long id,
        Long shopId,
        String shopName,
        Integer price,
        String name
) {

    public static ProductResponse from(
            ProductWithShop productWithShop
    ) {
        return new ProductResponse(
                productWithShop.id(),
                productWithShop.shopId(),
                productWithShop.shopName(),
                productWithShop.price(),
                productWithShop.name()
        );
    }
}
