package com.ecm.coreapi.controller.product.request;

import com.ecm.coredomain.domain.product.ProductInfo;

public record ProductSaveRequest(
        Long productGroupId,
        Long shopId,
        Integer price,
        Integer stock,
        String name
) {

    public ProductInfo toProductInfo() {
        return new ProductInfo(productGroupId, shopId, price, stock, name);
    }

}
