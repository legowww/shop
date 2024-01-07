package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.ProductPreview;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductMapper {

    public static ProductPreview mapToDomain(
            ProductEntity entity
    ) {
        return new ProductPreview(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }
}
