package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.ProductWithShop;
import com.ecm.coredomain.domain.product.ProductPreview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductEntityJpaRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.ProductWithShop
                    (p.id, s.id, s.name, p.price, p.name, p.createdAt)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.id = :productId
    """
    )
    Optional<ProductWithShop> findByProductId(Long productId);

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.ProductPreview
                    (p.id, p.name, p.price)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.productGroupId = :productGroupId
                    order by p.price asc
                    limit :size
    """
    )
    List<ProductPreview> findLowPriceProductsByProductGroupId(Long productGroupId, Integer size);

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.ProductPreview
                    (p.id, p.name, p.price)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.productGroupId = :productGroupId
    """
    )
    List<ProductPreview> findAllByProductGroupId(Long productGroupId);
}
