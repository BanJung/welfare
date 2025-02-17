package com.study.welfare.product.application;

import com.study.welfare.category.application.CategoryService;
import com.study.welfare.category.domain.Category;
import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.core.dto.ProductRequestDto;
import com.study.welfare.product.core.dto.ProductResponseDto;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Transactional
    public ProductResponseDto saveProduct(ProductRequestDto requestDto) {
        // Category 조회
        Category category = categoryService.findCategoryById(requestDto.getCategoryId());

        // Product 객체 생성
        Product product = Product.fromRequestDto(requestDto, category);

        // Product 저장
        productRepository.save(product);

        return product.toResponseDto();
    }


}
