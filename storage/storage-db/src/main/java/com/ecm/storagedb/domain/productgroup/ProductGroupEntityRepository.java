package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupRepository;
import com.ecm.storagedb.mapper.ProductGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@RequiredArgsConstructor
public class ProductGroupEntityRepository implements ProductGroupRepository {

    private final ProductGroupJpaRepository productGroupJpaRepository;
    @Transactional
    @Override
    public ProductGroup save(
            String code,
            String name
    ) {
        ProductGroupEntity productGroupEntity = productGroupJpaRepository.save(
                ProductGroupEntity.create(code, name)
        );

        return ProductGroupMapper.mapToDomain(productGroupEntity);
    }
}
