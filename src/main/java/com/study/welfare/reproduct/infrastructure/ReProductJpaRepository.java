package com.study.welfare.reproduct.infrastructure;

import com.study.welfare.product.infrastructure.ProductJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReProductJpaRepository extends JpaRepository<ReProductJpaEntity,Long> {
    List<ReProductJpaEntity> findBySellerName(String sellerName);
    List<ReProductJpaEntity> findByLocation(String location);
}
