package com.ecm.coredomain.domain.product;

import java.util.List;

public interface ProductCacheDao {

    List<ProductPreview> readLowPriceProducts(Long productGroupId, Integer size);

    void save(Long productGroupId, ProductPreview productPreview);
}
