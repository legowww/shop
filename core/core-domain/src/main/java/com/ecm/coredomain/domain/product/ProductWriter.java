package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ProductWriter {

    private final ProductRepository productRepository;

}
