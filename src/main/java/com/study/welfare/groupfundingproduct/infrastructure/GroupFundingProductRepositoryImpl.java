package com.study.welfare.groupfundingproduct.infrastructure;

import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import com.study.welfare.category.infrastructure.CategoryJpaRepository;
import com.study.welfare.exception.NotFoundException;
import com.study.welfare.groupfundingproduct.application.repository.GroupFundingProductRepository;
import com.study.welfare.groupfundingproduct.domain.GroupFundingProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GroupFundingProductRepositoryImpl implements GroupFundingProductRepository {

    private final GroupFundingProductJpaRepository groupFundingProductJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    @Transactional
    public void save(GroupFundingProduct groupFundingProduct){
        // Category 조회
        CategoryJpaEntity categoryJpaEntity = categoryJpaRepository.findById(groupFundingProduct.getProductCategoryId())
                .orElseThrow(()-> new NotFoundException("category", groupFundingProduct.getProductCategoryId()));

        groupFundingProductJpaRepository.save(GroupFundingProductJpaEntity.from(groupFundingProduct, categoryJpaEntity));
    }
}
