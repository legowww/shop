package com.ecm.coredomain.domain.product;


public record ProductPreview(
        Long productId,
        String name,
        Integer price
) {
}
