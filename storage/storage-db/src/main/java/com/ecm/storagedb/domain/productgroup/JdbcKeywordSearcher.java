package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.search.KeywordSearcher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class JdbcKeywordSearcher implements KeywordSearcher {

    public static final String FULLTEXT_NAME_QUERY = "SELECT * FROM product_groups WHERE MATCH(name) AGAINST(:keyword) limit :size";
    public static final String KEYWORD = "keyword";
    public static final String SIZE = "size";

    private final JdbcClient jdbcClient;

    @Override
    public List<ProductGroup> findByKeyword(
            String keyword,
            Integer size
    ) {
        return jdbcClient
                .sql(FULLTEXT_NAME_QUERY)
                .param(KEYWORD, keyword)
                .param(SIZE, size)
                .query(ProductGroup.class)
                .list();
    }
}


