package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductGroupSearchDaoImpl implements ProductGroupSearchDao {

    public static final String FULLTEXT_NAME_QUERY = "SELECT * FROM product_groups WHERE MATCH(name) AGAINST(:inputText)";
    public static final String INPUT_TEXT = "inputText";

    private final JdbcClient jdbcClient;

    @Override
    public List<ProductGroup> searchThroughInputText(
            String inputText
    ) {
        return jdbcClient
                .sql(FULLTEXT_NAME_QUERY)
                .param(INPUT_TEXT, inputText)
                .query(ProductGroup.class)
                .list();
    }
}
