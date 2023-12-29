package com.ecm.coredomain.domain.product;

import java.util.List;

public interface ProductRepository {

     List<ProductInfo>  searchLowPriceProducts(Long productGroupId);
}
