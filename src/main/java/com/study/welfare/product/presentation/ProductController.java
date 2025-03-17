package com.study.welfare.product.presentation;

import com.study.welfare.product.application.ProductService;
import com.study.welfare.product.core.dto.ProductRequestDTO;
import com.study.welfare.product.core.dto.ProductResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Product", description = "Product API")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 저장
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDto) {
        ProductResponseDTO responseDto = productService.saveProduct(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable Long id){
        ProductResponseDTO responseDTO = productService.findProductById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
