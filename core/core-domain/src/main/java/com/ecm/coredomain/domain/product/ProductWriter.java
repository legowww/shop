package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ProductWriter {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final ProductRepository productRepository;

    @Transactional
    public Long write(
            ProductInfo productInfo
    ) {
        ProductPreview productPreview = productRepository.save(productInfo);
        // check global cache
        applicationEventPublisher.publishEvent(new ProductSavedGlobalCacheEvent(productInfo.productGroupId(), productPreview));

        return productPreview.productId();
    }
}
