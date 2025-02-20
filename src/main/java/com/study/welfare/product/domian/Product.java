package com.study.welfare.product.domian;

import com.study.welfare.category.domain.Category;
import com.study.welfare.exception.InvalidResourceException;
import com.study.welfare.product.core.dto.ProductRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
@AllArgsConstructor
public class Product {

    // 상품 정보 관리
    private final Long productId;
    private final String productName;
    private final String productDescription;
    private final Category productCategory;
    private ProductPrice productPrice;
    private ProductStock  productStock;


    public static Product createFromRequestDTO(ProductRequestDTO requestDTO, Category category){
        if (requestDTO.getProductPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidResourceException("product_price", 0L);
        }
        if (requestDTO.getProductStock() < 1) {
            throw new InvalidResourceException("product_stock",0L);
        }

        return Product.builder()
                .productName(requestDTO.getProductName())
                .productDescription(requestDTO.getProductDescription())
                .productCategory(category)
                .productPrice(ProductPrice.applyPrice(requestDTO.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDTO.getProductStock()))
                .build();
    }



//    changeStock(quantity): 재고 변경
//    deleteProduct(): 상품 삭제
//    calculateDiscountedPrice(discount): 할인가 계산




}
