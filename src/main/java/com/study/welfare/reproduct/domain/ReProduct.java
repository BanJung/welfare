package com.study.welfare.reproduct.domain;

import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import com.study.welfare.reproduct.core.dto.ReProductRequestDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ReProduct extends Product {
    private final Long originalProductId;
    private final String sellerName; // 판매자
    private final String location; // 등록 위치
    private boolean isSold = false; // 판매 완료 여부


    public static ReProduct createFromRequestDTO(ReProductRequestDTO requestDTO){
        return ReProduct.builder()
                .productName(requestDTO.getProductName())
                .productDescription(requestDTO.getProductDescription())
                .productCategoryId(requestDTO.getCategoryId())
                .productPrice(ProductPrice.applyPrice(requestDTO.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDTO.getProductStock()))
                .originalProductId(requestDTO.getOriginalProductId())
                .sellerName(requestDTO.getSellerName())
                .location(requestDTO.getLocation())
                .isSold(false)
                .build();
    }
}
