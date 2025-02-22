package com.study.welfare.groupfundingproduct.core.dto;

import com.study.welfare.groupfundingproduct.domain.GroupFundingProduct;
import com.study.welfare.product.core.dto.ProductResponseDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class GroupFundingProductResponseDTO extends ProductResponseDTO {

    private int targetParticipants;
    private int currentParticipants;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static GroupFundingProductResponseDTO from (GroupFundingProduct groupFundingProduct){
        return GroupFundingProductResponseDTO.builder()
                .productName(groupFundingProduct.getProductName())
                .productDescription(groupFundingProduct.getProductDescription())
                .productCategoryId(groupFundingProduct.getProductCategoryId())
                .productPrice(groupFundingProduct.getProductPrice().getBasePrice())
                .targetParticipants(groupFundingProduct.getParticipantCount().getTargetParticipants())
                .currentParticipants(groupFundingProduct.getParticipantCount().getCurrentParticipants())
                .startDate(groupFundingProduct.getStartDate())
                .endDate(groupFundingProduct.getEndDate())
                .build();
    }
}
