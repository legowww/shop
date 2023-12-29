package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductEntityJpaRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.ProductInfo(p.id, s.id, s.name, p.productInfo.name, p.price)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.productGroupId = :productGroupId
                    order by p.price asc
                    limit 10
                    """
    )
    List<ProductInfo> findLowPriceProducts(Long productGroupId);
}
