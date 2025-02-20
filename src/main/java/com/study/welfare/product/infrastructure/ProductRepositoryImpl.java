package com.study.welfare.product.infrastructure;

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

    @Override
    @Transactional
    public void save(Product product){
        productJpaRepository.save(ProductJpaEntity.from(product));
    }

    @Override
    public Product findById(Long id){
        return productJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("product",id))
                .toModel();
    }
}
