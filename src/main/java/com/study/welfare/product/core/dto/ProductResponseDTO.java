package com.study.welfare.product.core.dto;

import com.study.welfare.product.domian.Product;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
public class ProductResponseDTO {

    private String productName;
    private String productDescription;
    private Integer productCategoryId;
    private BigDecimal productPrice;


    public static ProductResponseDTO from(Product product){
        return ProductResponseDTO.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productCategoryId(product.getProductCategoryId())
                .productPrice(product.getProductPrice().getBasePrice())
                .build();
    }

}
