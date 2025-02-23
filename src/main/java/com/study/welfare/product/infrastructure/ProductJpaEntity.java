package com.study.welfare.product.infrastructure;

import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type")
@DiscriminatorValue("PRODUCT")
@Table(name="product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryJpaEntity category;

    @Column(nullable = false)
    private BigDecimal price=BigDecimal.ZERO;

    @Column(nullable = false)
    private int stock=0;

    public ProductJpaEntity(String name, String description, CategoryJpaEntity category, BigDecimal price, int stock) {
        this.id=getId();
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public static ProductJpaEntity from(Product product, CategoryJpaEntity categoryJpaEntity) {
        return new ProductJpaEntity(
                product.getProductName(),
                product.getProductDescription(),
                //JPA Entity가 들어가야 하는 건 맞는데, 새로 생성해서 들어가는 게 아님(from을 사용하면 안됨)
                categoryJpaEntity,
                product.getProductPrice().getBasePrice(),
                product.getProductStock().getStock()
        );
    }


    public Product toModel(){
        return Product.builder()
                .productId(getId())
                .productName(getName())
                .productDescription(getDescription())
                .productCategoryId(getCategory().toModel().getCategoryId())
                .productPrice(ProductPrice.applyPrice(getPrice()))
                .productStock(ProductStock.applyStock(getStock()))
                .build();
    }
}
