package com.ecm.coredomain.domain.product;

import java.util.List;

public interface ProductRepository {

     Product findById(Long productId);

     List<ProductPreview> findLowPriceProductsByGrpId(Long productGroupId, Integer size);
}
