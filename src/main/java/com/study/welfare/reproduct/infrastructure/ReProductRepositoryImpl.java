package com.study.welfare.reproduct.infrastructure;

import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.category.infrastructure.CategoryJpaRepository;
import com.study.welfare.exception.NotFoundException;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
import com.study.welfare.product.infrastructure.ProductJpaRepository;
import com.study.welfare.reproduct.application.repository.ReProductRepository;
import com.study.welfare.reproduct.domain.ReProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReProductRepositoryImpl implements ReProductRepository {

    private final ReProductJpaRepository reProductJpaRepository;
    private final ProductJpaRepository productJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    @Transactional
    public void save(ReProduct reProduct){
        // Category 조회
        CategoryJpaEntity categoryJpaEntity = categoryJpaRepository.findById(reProduct.getProductCategoryId())
                .orElseThrow(()-> new NotFoundException("category", reProduct.getProductCategoryId()));

        // 원본 Product 조회
        ProductJpaEntity originalProduct = productJpaRepository.findById(reProduct.getOriginalProductId())
                .orElseThrow(()-> new NotFoundException("product",reProduct.getOriginalProductId()));

        reProductJpaRepository.save(ReProductJpaEntity.from(reProduct,categoryJpaEntity, originalProduct));
    }

}
