package com.ecm.coredomain.domain.productgroup;

import java.util.List;

public interface ProductGroupRepository {

    ProductGroup save(
            String keyword,
            String name
    );

    List<ProductGroup> findByKeyword(
            String keyword
    );
}
