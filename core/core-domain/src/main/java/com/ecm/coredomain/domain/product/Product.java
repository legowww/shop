package com.ecm.coredomain.domain.product;


import java.time.LocalDateTime;

public record Product(
        Long id,
        Long shopId,
        String shopName,
        Integer price,
        Double discountRate,
        String name,
        String description,
        LocalDateTime createdAt
) {
}
