package com.ecm.coredomain.domain.search;



import com.ecm.coredomain.domain.productgroup.ProductGroup;

import java.util.List;

public interface KeywordSearcher {

    List<ProductGroup> findByKeyword(String keyword, Integer size);
}
