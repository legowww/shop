package com.ecm.coredomain.domain.productgroup;

import java.util.List;

public record ProductGroupSearchResponse(
        Integer currPage,
        Integer totalPage,
        List<ProductGroup> productGroupList
) {
}
