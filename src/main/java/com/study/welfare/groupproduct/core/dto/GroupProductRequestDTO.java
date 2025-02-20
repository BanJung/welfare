package com.study.welfare.groupproduct.core.dto;

import com.study.welfare.product.core.dto.ProductRequestDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupProductRequestDTO extends ProductRequestDTO {

    @Positive(message = "목표 수량은 0보다 커야 합니다.")
    private int targetQuantity;

    @NotNull(message = "시작일 입력은 필수입니다.")
    private LocalDateTime startDate;

    @NotNull(message = "종료일 입력은 필수입니다.")
    private LocalDateTime endDate;
}
