package com.ecm.coredomain.domain.product;

import java.util.List;

public interface ProductRepository {

     ProductWithShop findById(Long productId);

     ProductPreview save(ProductInfo productInfo);

     List<ProductPreview> findLowPriceProducts(Long productGroupId, Integer size);
}
