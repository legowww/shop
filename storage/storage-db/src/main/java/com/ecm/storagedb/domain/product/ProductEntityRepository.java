package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.Product;
import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.coredomain.domain.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class ProductEntityRepository implements ProductRepository {

    private final ProductEntityJpaRepository productEntityJpaRepository;

    @Override
    public Product findById(
            Long productId
    ) {
        return productEntityJpaRepository.findByProductId(productId).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<ProductPreview> findLowPriceProductsByGrpId(
            Long productGroupId,
            Integer size
    ) {
        return productEntityJpaRepository.findLowPriceProductsByProductGroupId(productGroupId, size);
    }
}
