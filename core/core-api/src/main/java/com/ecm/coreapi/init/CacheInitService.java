package com.ecm.coreapi.init;


import com.ecm.coredomain.domain.product.ProductCacheDao;
import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.coredomain.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CacheInitService {

    private final ProductRepository productRepository;
    private final ProductCacheDao productCacheDao;

    public void init() {
        for (long pgrId=1; pgrId<=5; ++pgrId) {
            List<ProductPreview> productPreviews = productRepository.findLowPriceProducts(pgrId, 5);

            for (ProductPreview productPreview : productPreviews) {
                productCacheDao.save(pgrId, productPreview);
            }
        }
    }
}
