package com.study.welfare.reproduct.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.domian.Product;
import com.study.welfare.reproduct.application.repository.ReProductRepository;
import com.study.welfare.reproduct.core.dto.ReProductRequestDTO;
import com.study.welfare.reproduct.core.dto.ReProductResponseDTO;
import com.study.welfare.reproduct.domain.ReProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReProductService {

    private final ReProductRepository reProductRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ReProductResponseDTO saveReProduct(ReProductRequestDTO requestDto) {
        // Category 조회
        Category category = categoryRepository.findById(requestDto.getCategoryId());

        // 원본 Product 조회
        Product originalProduct = productRepository.findById(requestDto.getOriginalProductId());

        // ReProduct 객체 생성
        ReProduct reProduct = ReProduct.createFromRequestDTO(requestDto, category, originalProduct);

        // ReProduct 저장
        reProductRepository.save(reProduct);

        return ReProductResponseDTO.from(reProduct);
    }


}
