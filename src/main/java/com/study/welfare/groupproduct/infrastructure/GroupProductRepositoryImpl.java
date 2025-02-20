package com.study.welfare.groupproduct.infrastructure;

import com.study.welfare.groupproduct.application.repository.GroupProductRepository;
import com.study.welfare.groupproduct.domain.GroupProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GroupProductRepositoryImpl implements GroupProductRepository {

    private final GroupProductJpaRepository groupProductJpaRepository;

    @Override
    @Transactional
    public void save(GroupProduct groupProduct){

        groupProductJpaRepository.save(GroupProductJpaEntity.from(groupProduct));
    }
}
