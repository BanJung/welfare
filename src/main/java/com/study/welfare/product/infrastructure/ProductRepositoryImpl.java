package com.study.welfare.product.infrastructure;

import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.category.infrastructure.CategoryJpaRepository;
import com.study.welfare.exception.NotFoundException;
import com.study.welfare.product.application.repository.ProductRepository;
import com.study.welfare.product.domian.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    @Transactional
    public void save(Product product){
        // Category 조회
        CategoryJpaEntity categoryJpaEntity = categoryJpaRepository.findById(product.getProductCategoryId())
                .orElseThrow(()-> new NotFoundException("category", product.getProductCategoryId()));
        productJpaRepository.save(ProductJpaEntity.from(product, categoryJpaEntity));
    }

    @Override
    public Product findById(Long id){
        return productJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("product",id))
                .toModel();
    }

    @Override
    public ProductJpaEntity findEntityById(Long id){
        return productJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("product",id));
    }
}
