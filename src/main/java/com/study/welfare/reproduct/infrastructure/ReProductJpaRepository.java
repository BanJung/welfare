package com.study.welfare.reproduct.infrastructure;

import com.study.welfare.product.infrastructure.ProductJpaRepository;

import java.util.List;

public interface ReProductJpaRepository extends ProductJpaRepository {
    List<ReProductJpaEntity> findBySellerName(String sellerName);
    List<ReProductJpaEntity> findByLocation(String location);
}
