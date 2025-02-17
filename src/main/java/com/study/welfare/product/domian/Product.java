package com.study.welfare.product.domian;

import com.study.welfare.category.domain.Category;
import com.study.welfare.product.core.dto.ProductRequestDto;
import com.study.welfare.product.core.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Product {

    // 상품 정보 관리
    private final String productName;
    private final String productDescription;
    private final Category productCategory;
    private ProductPrice productPrice;
    private ProductStock  productStock;


    public static Product fromRequestDto (ProductRequestDto requestDto, Category category){
        return Product.builder()
                .productName(requestDto.getProductName())
                .productDescription(requestDto.getProductDescription())
                .productCategory(category)
                .productPrice(ProductPrice.applyPrice(requestDto.getProductPrice()))
                .productStock(ProductStock.applyStock(requestDto.getProductStock()))
                .build();
    }

    public ProductResponseDto toResponseDto (){
        return ProductResponseDto.builder()
                .productName(this.getProductName())
                .productDescription(this.getProductDescription())
                .categoryName(this.getProductCategory().getCategoryName())
                .productPrice(this.getProductPrice().getBasePrice())
                .build();
    }


    public static Product addProduct(String productName,String productDescription, ProductPrice productPrice,ProductStock productStock, Category productCategory){
        return Product.builder()
                .productName(productName)
                .productDescription(productDescription)
                .productCategory(productCategory)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }




//    changeStock(quantity): 재고 변경
//    deleteProduct(): 상품 삭제
//    calculateDiscountedPrice(discount): 할인가 계산




}
