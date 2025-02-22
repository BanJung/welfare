package com.study.welfare.reproduct.core.dto;

import com.study.welfare.product.core.dto.ProductResponseDTO;
import com.study.welfare.reproduct.domain.ReProduct;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ReProductResponseDTO extends ProductResponseDTO {

    private String sellerName;
    private String location;
    private boolean isSold;

    public static ReProductResponseDTO from (ReProduct reProduct){
        return ReProductResponseDTO.builder()
                .productName(reProduct.getProductName())
                .productDescription(reProduct.getProductDescription())
                .productCategoryId(reProduct.getProductCategoryId())
                .productPrice(reProduct.getProductPrice().getBasePrice())
                .sellerName(reProduct.getSellerName())
                .location(reProduct.getLocation())
                .isSold(reProduct.isSold())
                .build();
    }
}
