package com.study.welfare.product.application.repository;

import com.study.welfare.product.domian.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
}
