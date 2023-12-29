package com.ecm.storagedb.domain.productgroup;

import com.ecm.storagedb.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "product_groups",
        indexes = {@Index(name = "products_group_name_ix", columnList = "name")}
)
@Entity
public class ProductGroupEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Builder
    private ProductGroupEntity(
            String name
    ) {
        this.name = name;
    }

    public static ProductGroupEntity create(
            String name
    ) {
        return ProductGroupEntity.builder()
                .name(name)
                .build();
    }
}
