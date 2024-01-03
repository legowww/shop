package com.ecm.coredomain.domain.product;

public record ProductPreview(
        Long productId,
        Long shopId,
        String shopName,
        String name,
        Integer price
) {
}
