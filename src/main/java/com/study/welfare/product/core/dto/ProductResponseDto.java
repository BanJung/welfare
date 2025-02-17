package com.study.welfare.product.core.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {

    private final String productName;
    private final String productDescription;
    private final String categoryName;
    private final BigDecimal productPrice;

}
