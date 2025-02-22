package com.study.welfare.reproduct.application.repository;

import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.product.infrastructure.ProductJpaEntity;
import com.study.welfare.reproduct.domain.ReProduct;

public interface ReProductRepository {
    void save(ReProduct reProduct);
}
