package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class ProductReader {

    private final ProductRepository productRepository;

    public Product read(
            Long productId
    ) {
        return productRepository.findById(productId);
    }

    @Cacheable(cacheNames = "PRODUCT_GROUP", key = "#productGroupId", cacheResolver = "cacheResolver")
    public List<ProductPreview> readLowPriceProducts(
            Long productGroupId,
            Integer size
    ) {
        System.out.println("[GLBOAL] NO CACHING:" + productGroupId);
        return productRepository.findLowPriceProductsByGrpId(productGroupId, size);
    }
}
