package com.ecm.storagedb.mapper;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.storagedb.domain.productgroup.ProductGroupEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductGroupMapper {

    public static ProductGroup mapToDomain(
            ProductGroupEntity entity
    ) {
        return new ProductGroup(entity.getId(), entity.getCode());
    }
}
