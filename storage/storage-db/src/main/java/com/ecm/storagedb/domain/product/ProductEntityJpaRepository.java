package com.ecm.storagedb.domain.product;

import com.ecm.coredomain.domain.product.Product;
import com.ecm.coredomain.domain.product.ProductPreview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductEntityJpaRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.Product
                    (p.id, s.id, s.name, p.price, p.discountRate, p.productSpec.name, p.productSpec.description, p.createdAt)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.id = :productId
    """
    )
    Optional<Product> findByProductId(Long productId);

    @Query(
            value = """
                    SELECT new com.ecm.coredomain.domain.product.ProductPreview
                    (p.id, s.id, s.name, p.productSpec.name, p.price)
                    from ProductEntity p
                    join ShopEntity s on p.shopId = s.id
                    where p.productGroupId = :productGroupId
                    order by p.price asc
                    limit :size
    """
    )
    List<ProductPreview> findLowPriceProductsByProductGroupId(Long productGroupId, Integer size);
}
