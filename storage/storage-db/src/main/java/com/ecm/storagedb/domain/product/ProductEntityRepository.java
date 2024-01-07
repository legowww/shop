package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.ProductWithShop;
import com.ecm.coredomain.domain.product.ProductInfo;
import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.coredomain.domain.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class ProductEntityRepository implements ProductRepository {

    private final ProductEntityJpaRepository productEntityJpaRepository;

    @Override
    public ProductWithShop findById(
            Long productId
    ) {
        return productEntityJpaRepository.findByProductId(productId).orElseThrow(() -> new EntityNotFoundException());
    }

    @Transactional
    @Override
    public ProductPreview save(
            ProductInfo productInfo
    ) {
        ProductEntity entity = ProductEntity.builder()
                .productGroupId(productInfo.productGroupId())
                .shopId(productInfo.shopId())
                .price(productInfo.price())
                .stock(productInfo.stock())
                .name(productInfo.name())
                .build();
        ProductEntity savedEntity = productEntityJpaRepository.save(entity);

        return ProductMapper.mapToDomain(savedEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductPreview> findLowPriceProducts(
            Long productGroupId,
            Integer size
    ) {
        return productEntityJpaRepository.findLowPriceProductsByProductGroupId(productGroupId, size);
    }
}
