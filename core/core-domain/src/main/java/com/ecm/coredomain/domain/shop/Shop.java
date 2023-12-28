package com.ecm.coredomain.domain.shop;

import java.time.LocalDateTime;

public record Shop(
        Long id,
        Long userId,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
