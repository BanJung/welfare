package com.study.welfare.product.presentation;

import com.study.welfare.product.application.ProductService;
import com.study.welfare.product.core.dto.ProductRequestDto;
import com.study.welfare.product.core.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 저장
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto requestDto) {
        ProductResponseDto responseDto = productService.saveProduct(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
