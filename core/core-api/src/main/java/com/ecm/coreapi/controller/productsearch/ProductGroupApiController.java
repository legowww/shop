package com.ecm.coreapi.controller.productsearch;


import com.ecm.coreapi.controller.global.ApiResponse;
import com.ecm.coredomain.domain.product.ProductService;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchResponse;
import com.ecm.coredomain.domain.productgroup.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/v1/product-groups")
@RestController
public class ProductGroupApiController {

    private final ProductGroupService productGroupService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<ProductGroupSearchResponse>> search(
            @RequestParam String inputText,
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        ProductGroupSearchResponse response = productGroupService.search(inputText, page, size);

        return ResponseEntity.ok(ApiResponse.ok(response));
    }

}
