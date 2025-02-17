package com.study.welfare.product.core.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {

    private final String productName;
    private final String productDescription;
    private final int categoryId;
    private final BigDecimal productPrice;
    private final int productStock;

}
