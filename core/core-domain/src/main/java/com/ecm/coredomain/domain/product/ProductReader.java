package com.ecm.coredomain.domain.product;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductReader {

    private static final Logger log = LoggerFactory.getLogger("file");
    private final ProductRepository productRepository;
    private final ProductCacheDao productCacheDao;

    @Transactional(readOnly = true)
    public ProductWithShop read(
            Long productId
    ) {
        return productRepository.findById(productId);
    }

    public List<ProductPreview> readLowPriceProducts(
            Long productGroupId,
            Integer size
    ) {
        List<ProductPreview> cacheProductPreviews = productCacheDao.readLowPriceProducts(productGroupId, size);

        if (cacheProductPreviews.isEmpty()) {
            log.info("[ProductReader:readLowPriceProducts] [Use DB Data] productGroupId={}", productGroupId);
            List<ProductPreview> productPreviews = productRepository.findLowPriceProducts(productGroupId, size);

            for (ProductPreview productPreview : productPreviews) {
                productCacheDao.save(productGroupId, productPreview);
            }

            return productPreviews;
        }

        return cacheProductPreviews;
    }
}
