package com.ecm.coreapi.controller.product;


import com.ecm.coreapi.global.ApiResponse;
import com.ecm.coredomain.domain.product.Product;
import com.ecm.coredomain.domain.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1/products")
@RestController
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<?>> findProduct(
            @PathVariable Long productId
    ) {
        Product product = productService.find(productId);

        return ResponseEntity.ok(ApiResponse.ok(product));
    }
}
