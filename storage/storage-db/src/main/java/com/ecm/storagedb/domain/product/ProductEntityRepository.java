package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.ProductInfo;
import com.ecm.coredomain.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class ProductEntityRepository implements ProductRepository {

    private final ProductEntityJpaRepository productEntityJpaRepository;

    @Override
    public List<ProductInfo> searchLowPriceProducts(Long productGroupId) {
        return productEntityJpaRepository.findLowPriceProducts(productGroupId);
    }
}
