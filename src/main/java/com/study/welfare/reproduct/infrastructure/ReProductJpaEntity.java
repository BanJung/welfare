package com.study.welfare.reproduct.infrastructure;

import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
import com.study.welfare.reproduct.domain.ReProduct;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "re_product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("USED")
public class ReProductJpaEntity  extends ProductJpaEntity  {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_product_id", nullable = false)
    private ProductJpaEntity originalProduct; // 원본 상품

    @Column(nullable = false)
    private String sellerName;  // 판매자

    @Column(nullable = false)
    private String location;  // 등록 위치

    @Column(nullable = false)
    private boolean isSold = false;  // 판매 완료 여부

    public ReProductJpaEntity(String name, String description, CategoryJpaEntity category, BigDecimal price, int stock,
                              ProductJpaEntity originalProduct, String sellerName, String location, boolean isSold) {
        super(name, description, category, price, stock);
        this.originalProduct=originalProduct;
        this.sellerName = sellerName;
        this.location = location;
        this.isSold=isSold;
    }

    public static ReProductJpaEntity from(ReProduct reProduct, CategoryJpaEntity categoryJpaEntity, ProductJpaEntity originalProduct) {
        return new ReProductJpaEntity(
                reProduct.getProductName(),
                reProduct.getProductDescription(),
                categoryJpaEntity,
                reProduct.getProductPrice().getBasePrice(),
                reProduct.getProductStock().getStock(),
                originalProduct,
                reProduct.getSellerName(),
                reProduct.getLocation(),
                reProduct.isSold()
        );
    }

    public ReProduct toModel() {
        return ReProduct.builder()
                .productName(getName())
                .productDescription(getDescription())
                .productCategoryId(getCategory().getId())
                .productPrice(ProductPrice.applyPrice(getPrice()))
                .productStock(ProductStock.applyStock(getStock()))
                .originalProductId(getOriginalProduct().getId())
                .sellerName(getSellerName())
                .location(getLocation())
                .isSold(isSold())
                .build();
    }
}
