package com.ecm.coredomain.domain.product;

public record ProductInfo(
        Long productId,
        Long shopId,
        String shopName,
        String name,
        Integer price
) {
}
