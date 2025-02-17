package com.study.welfare.category.infrastructure;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    @Override
    public Category findById(int id){
        return categoryJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("category",id))
                .toModel();
    }
}
