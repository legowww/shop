package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupRepository;
import com.ecm.storagedb.mapper.ProductGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductGroupEntityRepository implements ProductGroupRepository {

    private final ProductGroupJpaRepository productGroupJpaRepository;

    @Override
    public ProductGroup save(
            String keyword,
            String code
    ) {
        ProductGroupEntity productGroupEntity = productGroupJpaRepository.save(
                ProductGroupEntity.create(keyword, code)
        );

        return ProductGroupMapper.mapToDomain(productGroupEntity);
    }

    @Override
    public List<ProductGroup> findByKeyword(
            String keyword
    ) {
        List<ProductGroupEntity> productGroupEntityList = productGroupJpaRepository.findByKeyword(keyword);

        return productGroupEntityList.stream()
                .map(ProductGroupMapper::mapToDomain)
                .toList();
    }
}
