package com.study.welfare.product.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.core.dto.ProductRequestDTO;
import com.study.welfare.product.core.dto.ProductResponseDTO;
import com.study.welfare.product.domian.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ProductResponseDTO saveProduct(ProductRequestDTO requestDto) {
        // Category 조회
        Category category = categoryRepository.findById(requestDto.getCategoryId());

        // Product 객체 생성
        Product product = Product.createFromRequestDTO(requestDto, category);

        // Product 저장
        productRepository.save(product);

        return ProductResponseDTO.from(product);
    }

    public ProductResponseDTO findProductById(Long id) {

        Product product = productRepository.findById(id);
        return ProductResponseDTO.from(product);
    }


}
