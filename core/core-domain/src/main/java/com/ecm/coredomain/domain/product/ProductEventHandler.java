package com.ecm.coredomain.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class ProductEventHandler {

    private final ProductCacheDao productCacheDao;

    @Async
    @EventListener(ProductSavedGlobalCacheEvent.class)
    @TransactionalEventListener(
            classes = ProductSavedGlobalCacheEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handle(ProductSavedGlobalCacheEvent event) {
        productCacheDao.save(event.productGroupId(), event.productPreview());
    }
}
