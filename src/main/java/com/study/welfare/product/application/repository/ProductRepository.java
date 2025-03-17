package com.study.welfare.product.application.repository;

import com.study.welfare.product.domian.Product;
import com.study.welfare.product.infrastructure.ProductJpaEntity;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
    ProductJpaEntity findEntityById(Long id);
}
