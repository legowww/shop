package com.ecm.storagedb.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ProductSpec {

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 30)
    private String modelNumber;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer releasePrice;
}
