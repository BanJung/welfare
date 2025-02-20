package com.study.welfare.product.core.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "상품명은 필수입니다.")
    private String productName;
    private String productDescription;
    @NotNull(message = "카테고리는 필수입니다.")
    private int categoryId;
    @Positive(message = "가격은 0보다 커야 합니다.")
    private BigDecimal productPrice;
    @Min(value = 1, message = "재고는 1 이상이어야 합니다.")
    private int productStock;
}
