package com.ecm.coreapi.controller.product;


import com.ecm.coreapi.controller.global.ApiResponse;
import com.ecm.coredomain.domain.product.LowPriceProductSearchResponse;
import com.ecm.coredomain.domain.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/v1/product-search")
@RestController
public class ProductSearchApiController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<LowPriceProductSearchResponse>> search(
            @RequestParam String keyword
    ) {
        LowPriceProductSearchResponse response = productService.keywordSearch(keyword);

        return ResponseEntity.ok(ApiResponse.ok(response));
    }
}
