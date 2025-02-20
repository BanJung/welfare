package com.study.welfare.product.domian;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductStock {
    private int stock;

    public static ProductStock applyStock(int stock) {
        return ProductStock.builder()
                .stock(stock)
                .build();
    }

    public void increaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("추가할 재고는 0 이상이어야 합니다.");
        }
        this.stock += quantity;
    }

    public void decreaseStock(int quantity) {
        if (quantity < 0 || quantity > stock) {
            throw new IllegalArgumentException("잘못된 재고 감소 요청입니다.");
        }
        this.stock -= quantity;
    }
}
