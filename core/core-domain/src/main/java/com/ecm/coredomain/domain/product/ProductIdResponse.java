package com.ecm.coredomain.domain.product;

public record ProductIdResponse(
        Long id
) {

    public static ProductIdResponse from(Long productId) {
        return new ProductIdResponse(productId);
    }
}
