package com.study.welfare.reproduct.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.domian.Product;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
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

    @Transactional
    public ReProductResponseDTO saveReProduct(ReProductRequestDTO requestDTO) {
        // ReProduct 객체 생성
        ReProduct reProduct = ReProduct.createFromRequestDTO(requestDTO);

        // ReProduct 저장
        reProductRepository.save(reProduct);

        return ReProductResponseDTO.from(reProduct);
    }


}
