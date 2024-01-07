package com.ecm.coredomain.domain.product;

public record ProductInfo(
        Long productGroupId,
        Long shopId,
        Integer price,
        Integer stock,
        String name
) {
}
