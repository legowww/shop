package com.ecm.coredomain.domain.productgroup;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductGroupReader {

    private final ProductGroupSearchDao productSearchDao;

    @Transactional(readOnly = true)
    public ProductGroupSearchResponse read(
            String inputText,
            Integer page,
            Integer size
    ) {
        return productSearchDao.searchThroughInputText(inputText, page, size);
    }
}
