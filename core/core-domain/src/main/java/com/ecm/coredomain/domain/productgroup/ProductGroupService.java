package com.ecm.coredomain.domain.productgroup;


import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductGroupService {

    private final ProductGroupReader productGroupReader;

    public ProductGroupSearchResponse search(
            String inputText,
            Integer page,
            Integer size
    ) {
        return productGroupReader.read(inputText, page, size);
    }
}
