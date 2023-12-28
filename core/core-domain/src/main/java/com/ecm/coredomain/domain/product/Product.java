package com.ecm.coredomain.domain.product;


import java.time.LocalDateTime;

public record Product(
        Long id,
        Long productGroupId,
        Long shopId,
        Integer price,
        Double discountRate,
        String name,
        String modelNumber,
        String color,
        Integer releasePrice,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
