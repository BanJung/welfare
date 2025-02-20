package com.study.welfare.groupproduct.core.dto;

import com.study.welfare.groupproduct.domain.GroupProduct;
import com.study.welfare.product.core.dto.ProductResponseDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class GroupProductResponseDTO extends ProductResponseDTO {

    private int targetQuantity;
    private int currentParticipants;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static GroupProductResponseDTO from (GroupProduct groupProduct){
        return GroupProductResponseDTO.builder()
                .productName(groupProduct.getProductName())
                .productDescription(groupProduct.getProductDescription())
                .categoryName(groupProduct.getProductCategory().getCategoryName())
                .productPrice(groupProduct.getProductPrice().getBasePrice())
                .targetQuantity(groupProduct.getTargetQuantity())
                .currentParticipants(groupProduct.getCurrentParticipants())
                .startDate(groupProduct.getStartDate())
                .endDate(groupProduct.getEndDate())
                .build();
    }
}
