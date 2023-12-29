package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.productgroup.ProductGroupReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LowPriceProductSearcher {

    private final ProductReader productReader;
    private final ProductGroupReader productGroupReader;

    @Transactional(readOnly = true)
    public List<ProductGroupMainLowPriceProduct> search(
            String keyword
    ) {
        return productGroupReader.read(keyword).stream()
                .map(productGroup -> {
                    List<ProductInfo> lowPriceProducts = productReader.read(productGroup.id());

                    return new ProductGroupMainLowPriceProduct(productGroup, lowPriceProducts);
                }
                ).toList();
    }
}
