package com.study.welfare.groupproduct.infrastructure;

import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.groupproduct.domain.GroupProduct;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("GROUP")
public class GroupProductJpaEntity extends ProductJpaEntity  {
    @Column(nullable = false)
    private int targetQuantity;  // 목표 수량

    @Column(nullable = false)
    private int currentParticipants = 0;  // 현재 참여 인원

    @Column(nullable = false)
    private LocalDateTime startDate;  // 공동구매 시작 시간

    @Column(nullable = false)
    private LocalDateTime endDate;    // 마감 기한


    public GroupProductJpaEntity(String name, String description, CategoryJpaEntity category, BigDecimal price, int stock,
                                 int targetQuantity, int currentParticipants, LocalDateTime startDate, LocalDateTime endDate) {
        super(name, description, category, price, stock);
        this.targetQuantity = targetQuantity;
        this.currentParticipants=currentParticipants;
        this.startDate = startDate;
        this.endDate=endDate;
    }

    public static GroupProductJpaEntity from(GroupProduct groupProduct) {
        return new GroupProductJpaEntity(
                groupProduct.getProductName(),
                groupProduct.getProductDescription(),
                CategoryJpaEntity.from(groupProduct.getProductCategory()),
                groupProduct.getProductPrice().getBasePrice(),
                groupProduct.getProductStock().getStock(),
                groupProduct.getTargetQuantity(),
                groupProduct.getCurrentParticipants(),
                groupProduct.getStartDate(),
                groupProduct.getEndDate()
        );
    }

    public GroupProduct toModel() {
        return GroupProduct.builder()
                .productName(getName())
                .productDescription(getDescription())
                .productCategory(getCategory().toModel())
                .productPrice(ProductPrice.applyPrice(getPrice()))
                .productStock(ProductStock.applyStock(getStock()))
                .targetQuantity(this.targetQuantity)
                .currentParticipants(this.currentParticipants)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
