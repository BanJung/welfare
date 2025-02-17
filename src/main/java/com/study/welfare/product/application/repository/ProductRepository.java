package com.study.welfare.product.application.repository;

import com.study.welfare.product.domian.Product;
import com.study.welfare.product.infrastructure.ProductJpaEntity;

public interface ProductRepository {
    public void save(Product product);
}
