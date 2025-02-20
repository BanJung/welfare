package com.study.welfare.reproduct.domain;

import com.study.welfare.category.domain.Category;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.domian.ProductPrice;
import com.study.welfare.product.domian.ProductStock;
import com.study.welfare.reproduct.core.dto.ReProductRequestDTO;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ReProduct extends Product {
    private final Product originalProduct;
    private final String sellerName; // 판매자
    private final String location; // 등록 위치
    private boolean isSold = false; // 판매 완료 여부


    public static ReProduct createFromRequestDTO(ReProductRequestDTO requestDTO, Category category, Product product){
        return ReProduct.builder()
                .productName(requestDTO.getProductName())
                .productDescription(requestDTO.getProductDescription())
                .productCategory(category)
                .productPrice(ProductPrice.applyPrice(requestDTO.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDTO.getProductStock()))
                .originalProduct(product)
                .sellerName(requestDTO.getSellerName())
                .location(requestDTO.getLocation())
                .isSold(false)
                .build();
    }
}
