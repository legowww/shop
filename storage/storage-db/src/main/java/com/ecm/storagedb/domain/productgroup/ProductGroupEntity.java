package com.ecm.storagedb.domain.productgroup;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_groups")
@Entity
public class ProductGroupEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword",  nullable = false, length = 30)
    private String keyword;

    @Column(name = "code",  nullable = false, length = 30)
    private String code;

    @Builder
    private ProductGroupEntity(
            String keyword,
            String code
    ) {
        this.keyword = keyword;
        this.code = code;
    }

    public static ProductGroupEntity create(
            String keyword,
            String code
    ) {
        return ProductGroupEntity.builder()
                .keyword(keyword)
                .code(code)
                .build();
    }
}
