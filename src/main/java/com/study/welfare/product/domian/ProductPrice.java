package com.study.welfare.product.domian;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Getter
@RequiredArgsConstructor
@Builder
public class ProductPrice {
    private final BigDecimal basePrice;
    public static ProductPrice applyPrice(BigDecimal basePrice) {
        return ProductPrice.builder()
                .basePrice(basePrice)
                .build();
    }
}
