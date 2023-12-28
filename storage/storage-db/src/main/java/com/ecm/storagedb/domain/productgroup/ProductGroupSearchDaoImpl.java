package com.ecm.storagedb.domain.productgroup;

import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchDao;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductGroupSearchDaoImpl implements ProductGroupSearchDao {

    public static final String FULLTEXT_NAME_QUERY = "SELECT * FROM product_groups WHERE MATCH(name) AGAINST(:inputText) limit :limit offset :offset";
    public static final String COUNT_QUERY = "SELECT COUNT(*) FROM product_groups WHERE MATCH(name) AGAINST(:inputText)";
    public static final String INPUT_TEXT = "inputText";
    public static final String OFFSET = "offset";
    public static final String LIMIT = "limit";

    private final JdbcClient jdbcClient;

    @Override
    public ProductGroupSearchResponse searchThroughInputText(
            String inputText,
            Integer page,
            Integer size
    ) {
        List<ProductGroup> result = jdbcClient
                .sql(FULLTEXT_NAME_QUERY)
                .param(INPUT_TEXT, inputText)
                .param(LIMIT, size)
                .param(OFFSET, page * size)
                .query(ProductGroup.class)
                .list();

        Integer resultCount = jdbcClient
                .sql(COUNT_QUERY)
                .param(INPUT_TEXT, inputText)
                .query(Integer.class)
                .single();

        Integer totalPage = getPageCount(resultCount, size);

        return new ProductGroupSearchResponse(page, totalPage, result);

    }

    public Integer getPageCount(
            Integer totalCount,
            Integer size

    ) {
        return (int) Math.ceil((double) totalCount / size) - 1;
    }
}
