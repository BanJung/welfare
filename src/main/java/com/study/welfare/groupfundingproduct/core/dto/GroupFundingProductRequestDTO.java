package com.study.welfare.groupfundingproduct.core.dto;

import com.study.welfare.product.core.dto.ProductRequestDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupFundingProductRequestDTO extends ProductRequestDTO {

    @Positive(message = "목표 수량은 0보다 커야 합니다.")
    private int targetParticipants;

    @NotNull(message = "시작일 입력은 필수입니다.")
    private LocalDateTime startDate;

    @NotNull(message = "종료일 입력은 필수입니다.")
    private LocalDateTime endDate;
}
