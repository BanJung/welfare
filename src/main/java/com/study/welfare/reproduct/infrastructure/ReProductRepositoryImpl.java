package com.study.welfare.reproduct.infrastructure;

import com.study.welfare.reproduct.application.repository.ReProductRepository;
import com.study.welfare.reproduct.domain.ReProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReProductRepositoryImpl implements ReProductRepository {

    private final ReProductJpaRepository reProductJpaRepository;

    @Override
    @Transactional
    public void save(ReProduct reProduct){
        reProductJpaRepository.save(ReProductJpaEntity.from(reProduct));
    }

}
