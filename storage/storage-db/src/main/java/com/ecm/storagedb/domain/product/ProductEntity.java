package com.ecm.storagedb.domain.product;

import com.ecm.storagedb.domain.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Column(nullable = false, columnDefinition = "int unsigned")
    private Integer stock;

    @Column(nullable = false, length = 50)
    private String name;

    @Builder
    public ProductEntity(Long productGroupId, Long shopId, Integer price, Integer stock, String name) {
        this.productGroupId = productGroupId;
        this.shopId = shopId;
        this.price = price;
        this.stock = stock;
        this.name = name;
    }
}
