package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.productgroup.ProductGroupSearchDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductReader {

    private final ProductGroupSearchDao productSearchDao;




}
