package com.ecm.coreapi.controller.productsearch;


import com.ecm.coreapi.controller.global.ApiResponse;
import com.ecm.coredomain.domain.product.ProductService;
import com.ecm.coredomain.domain.productgroup.ProductGroup;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/v1/products")
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/group-search")
    public ResponseEntity<ApiResponse<String>> search(
            @RequestParam String productGroupId
    ) {


        return ResponseEntity.ok(ApiResponse.ok("response"));
    }
}
