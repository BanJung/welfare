package com.study.welfare.groupfundingproduct.domain;

import com.study.welfare.category.domain.Category;
import com.study.welfare.groupfundingproduct.core.dto.GroupFundingProductRequestDTO;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class GroupFundingProduct extends Product {
    private ParticipantCount participantCount;
    private final LocalDateTime startDate;  // 공동구매 시작 시간
    private final LocalDateTime endDate;    // 마감 기한

    public static GroupFundingProduct createFromRequestDTO(GroupFundingProductRequestDTO requestDTO){
        return GroupFundingProduct.builder()
                .productName(requestDTO.getProductName())
                .productDescription(requestDTO.getProductDescription())
                .productCategoryId(requestDTO.getCategoryId())
                .productPrice(ProductPrice.applyPrice(requestDTO.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDTO.getProductStock()))
                .participantCount(ParticipantCount.applyParticipantCount(requestDTO.getTargetParticipants()))
                .startDate(requestDTO.getStartDate())
                .endDate(requestDTO.getEndDate())
                .build();
    }
}
