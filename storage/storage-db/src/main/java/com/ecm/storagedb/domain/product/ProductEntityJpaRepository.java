package com.ecm.storagedb.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityJpaRepository extends JpaRepository<ProductEntity, Long> {
}
