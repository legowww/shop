package com.ecm.coredomain.domain.productgroup;


public interface ProductGroupSearchDao {

    ProductGroupSearchResponse searchThroughInputText(String inputText, Integer page, Integer size);
}
