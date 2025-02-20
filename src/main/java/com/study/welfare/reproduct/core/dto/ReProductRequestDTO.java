package com.study.welfare.reproduct.core.dto;

import com.study.welfare.product.core.dto.ProductRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReProductRequestDTO extends ProductRequestDTO {

    @NotNull(message = "상품 입력은 필수입니다.")
    private Long originalProductId;

    @NotNull(message = "판매자명 입력은 필수입니다.")
    private String sellerName;

    @NotNull(message = "주소는 필수입니다.")
    private String location;
}
