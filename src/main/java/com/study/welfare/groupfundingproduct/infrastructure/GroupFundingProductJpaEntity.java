package com.study.welfare.groupfundingproduct.infrastructure;

import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.groupfundingproduct.domain.GroupFundingProduct;
import com.study.welfare.groupfundingproduct.domain.ParticipantCount;
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
public class GroupFundingProductJpaEntity extends ProductJpaEntity  {
    @Column(nullable = false)
    private int targetParticipants;  // 목표 인원

    @Column(nullable = false)
    private int currentParticipants = 0;  // 현재 참여 인원

    @Column(nullable = false)
    private LocalDateTime startDate;  // 공동구매 시작 시간

    @Column(nullable = false)
    private LocalDateTime endDate;    // 마감 기한


    public GroupFundingProductJpaEntity(String name, String description, CategoryJpaEntity category, BigDecimal price, int stock,
                                 int targetParticipants, int currentParticipants, LocalDateTime startDate, LocalDateTime endDate) {
        super(name, description, category, price, stock);
        this.targetParticipants = targetParticipants;
        this.currentParticipants=currentParticipants;
        this.startDate = startDate;
        this.endDate=endDate;
    }

    public static GroupFundingProductJpaEntity from(GroupFundingProduct groupFundingProduct, CategoryJpaEntity categoryJpaEntity) {
        return new GroupFundingProductJpaEntity(
                groupFundingProduct.getProductName(),
                groupFundingProduct.getProductDescription(),
                categoryJpaEntity,
                groupFundingProduct.getProductPrice().getBasePrice(),
                groupFundingProduct.getProductStock().getStock(),
                groupFundingProduct.getParticipantCount().getTargetParticipants(),
                groupFundingProduct.getParticipantCount().getCurrentParticipants(),
                groupFundingProduct.getStartDate(),
                groupFundingProduct.getEndDate()
        );
    }

    public GroupFundingProduct toModel() {
        return GroupFundingProduct.builder()
                .productName(getName())
                .productDescription(getDescription())
                .productCategoryId(getCategory().getId())
                .productPrice(ProductPrice.applyPrice(getPrice()))
                .productStock(ProductStock.applyStock(getStock()))
                .participantCount(ParticipantCount.applyParticipantCount(getTargetParticipants(),getCurrentParticipants()))
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
