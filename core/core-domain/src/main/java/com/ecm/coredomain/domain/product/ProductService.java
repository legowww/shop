package com.ecm.coredomain.domain.product;


import com.ecm.coredomain.domain.productgroup.ProductGroupReader;
import com.ecm.coredomain.domain.productgroup.ProductGroupSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductGroupReader productGroupReader;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ProductGroupSearchResponse search(
            String inputText,
            Integer page,
            Integer size
    ) {
        //Event -> inputText 레디스 검색 랭킹 서버
        applicationEventPublisher.publishEvent(inputText);

        return productGroupReader.read(inputText, page, size);
    }
}
