package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductReader productReader;

    public Product find(
            Long productId
    ) {
        return productReader.read(productId);
    }
}
