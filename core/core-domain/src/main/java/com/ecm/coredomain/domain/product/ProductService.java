package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.product.reponse.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductReader productReader;
    private final ProductWriter productWriter;

    public ProductResponse find(
            Long productId
    ) {
        ProductWithShop productWithShop = productReader.read(productId);
        return ProductResponse.from(productWithShop);
    }

    public ProductIdResponse save(
            ProductInfo productInfo
    ) {
        Long productId = productWriter.write(productInfo);
        return ProductIdResponse.from(productId);
    }
}
