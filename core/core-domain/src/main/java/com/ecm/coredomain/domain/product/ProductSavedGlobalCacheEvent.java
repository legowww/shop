package com.ecm.coredomain.domain.product;

public record ProductSavedGlobalCacheEvent(
        Long productGroupId,

        ProductPreview productPreview
) {
}
