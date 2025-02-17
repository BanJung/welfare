package com.study.welfare.product.infrastructure;

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
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public static ProductJpaEntity from(Product product) {
        return new ProductJpaEntity(
                product.getProductName(),
                product.getProductDescription(),
                CategoryJpaEntity.from(product.getProductCategory()),
                product.getProductPrice().basePrice(),
                product.getProductStock().getStock()
        );
    }

    public Product toModel(){
        return Product.builder()
                .productName(this.name)
                .productDescription(this.description)
                .productPrice(ProductPrice.applyPrice(this.price))
                .productStock(ProductStock.applyStock(this.stock))
                .productCategory((this.category).toModel())
                .build();
    }
}
