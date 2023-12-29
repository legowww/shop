package com.ecm.coredomain.domain.productgroup;


import java.util.List;

public interface ProductGroupSearchDao {

    List<ProductGroup> searchThroughInputText(String inputText);
}
