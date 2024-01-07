package com.ecm.coreapi.controller.productsearch;


import com.ecm.coreapi.global.ApiResponse;
import com.ecm.coredomain.domain.product.ProductSearchNoCacheService;
import com.ecm.coredomain.domain.product.ProductSearchService;
import com.ecm.coredomain.domain.product.reponse.KeywordSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/v1/product-search")
@RestController
public class ProductSearchApi {

    private final ProductSearchService productSearchService;
    private final ProductSearchNoCacheService productSearchNoCacheService;
    @GetMapping
    public ResponseEntity<ApiResponse<KeywordSearchResponse>> search(
            @RequestParam String keyword
    ) {
        KeywordSearchResponse response = productSearchService.keywordSearch(keyword);

        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @GetMapping("/no-cache")
    public ResponseEntity<ApiResponse<KeywordSearchResponse>> searchNoCache(
            @RequestParam String keyword
    ) {
        KeywordSearchResponse response = productSearchNoCacheService.keywordSearch(keyword);

        return ResponseEntity.ok(ApiResponse.ok(response));
    }
}
