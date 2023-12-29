package com.ecm.storagedb.domain.product;

import com.ecm.storagedb.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
@Entity
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productGroupId;

    @Column(nullable = false)
    private Long shopId;

    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer price;

    @Column(nullable = false, columnDefinition = "double unsigned")
    private Double discountRate;

    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer stock;

    @Embedded
    private ProductSpec productInfo;
}
