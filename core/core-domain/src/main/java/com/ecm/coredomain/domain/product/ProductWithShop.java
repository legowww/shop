package com.ecm.coredomain.domain.product;


import java.time.LocalDateTime;

public record ProductWithShop(
        Long id,
        Long shopId,
        String shopName,
        Integer price,
        String name,
        LocalDateTime createdAt
) {
}
