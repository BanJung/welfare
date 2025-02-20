package com.study.welfare.groupproduct.domain;

import com.study.welfare.category.domain.Category;
import com.study.welfare.groupproduct.core.dto.GroupProductRequestDTO;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class GroupProduct extends Product {
    private final int targetQuantity; // 목표 수량
    private int currentParticipants=0; // 현재 참여 인원
    private final LocalDateTime startDate;  // 공동구매 시작 시간
    private final LocalDateTime endDate;    // 마감 기한

    public static GroupProduct createFromRequestDTO(GroupProductRequestDTO requestDTO, Category category){
        return GroupProduct.builder()
                .productName(requestDTO.getProductName())
                .productDescription(requestDTO.getProductDescription())
                .productCategory(category)
                .productPrice(ProductPrice.applyPrice(requestDTO.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDTO.getProductStock()))
                .targetQuantity(requestDTO.getTargetQuantity())
                .currentParticipants(0)
                .startDate(requestDTO.getStartDate())
                .endDate(requestDTO.getEndDate())
                .build();
    }
}
