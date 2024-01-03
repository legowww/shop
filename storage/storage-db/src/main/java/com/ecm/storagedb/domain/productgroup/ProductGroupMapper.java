package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductGroupMapper {

    public static ProductGroup mapToDomain(
            ProductGroupEntity entity
    ) {
        return new ProductGroup(entity.getId(), entity.getName());
    }
}
