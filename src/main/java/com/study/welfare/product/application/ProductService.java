package com.study.welfare.product.application;

import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.core.dto.ProductRequestDTO;
import com.study.welfare.product.core.dto.ProductResponseDTO;
import com.study.welfare.product.domian.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDTO saveProduct(ProductRequestDTO requestDTO) {
        // Product 객체 생성
        Product product = Product.createFromRequestDTO(requestDTO);

        // Product 저장
        productRepository.save(product);

        return ProductResponseDTO.from(product);
    }

    public ProductResponseDTO findProductById(Long id) {

        Product product = productRepository.findById(id);
        return ProductResponseDTO.from(product);
    }


}
