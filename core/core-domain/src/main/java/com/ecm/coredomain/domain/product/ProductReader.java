package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductReader {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductInfo>  read(
            Long productGroupId
    ) {
        return productRepository.searchLowPriceProducts(productGroupId);
    }
}
