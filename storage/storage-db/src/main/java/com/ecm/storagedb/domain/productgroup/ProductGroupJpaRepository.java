package com.ecm.storagedb.domain.productgroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGroupJpaRepository extends JpaRepository<ProductGroupEntity, Long> {

    List<ProductGroupEntity> findByKeyword(String keyword);
}
