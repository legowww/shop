package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final LowPriceProductSearcher lowPriceProductSearcher;

    public LowPriceProductSearchResponse keywordSearch(
            String keyword
    ) {
        List<ProductGroupMainLowPriceProduct> result = lowPriceProductSearcher.search(keyword);

        return new LowPriceProductSearchResponse(result);
    }
}
