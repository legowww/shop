package com.ecm.coreapi.controller.product;


import com.ecm.coreapi.controller.product.request.ProductSaveRequest;
import com.ecm.coreapi.global.ApiResponse;
import com.ecm.coredomain.domain.product.ProductIdResponse;
import com.ecm.coredomain.domain.product.ProductService;
import com.ecm.coredomain.domain.product.reponse.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/products")
@RestController
public class ProductApi {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductResponse>> find(
            @PathVariable Long productId
    ) {
        ProductResponse response = productService.find(productId);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductIdResponse>> save(
            @RequestBody ProductSaveRequest request
    ) {
        ProductIdResponse response = productService.save(request.toProductInfo());
        return ResponseEntity.ok(ApiResponse.ok(response));
    }
}
