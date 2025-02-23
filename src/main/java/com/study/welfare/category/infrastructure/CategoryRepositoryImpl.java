package com.study.welfare.category.infrastructure;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    @Transactional
    public void save(Category category){
        categoryJpaRepository.save(CategoryJpaEntity.from(category));
    }
    @Override
    public Category findById(Integer id){
        return categoryJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("category",id))
                .toModel();
    }

    @Override
    public Page<Category> findAllSortedByName(Pageable pageable) {
        return categoryJpaRepository.findAllSortedByName(pageable)
                .map(CategoryJpaEntity::toModel);
    }

    @Override
    public CategoryJpaEntity findEntityById(Integer id){
        return categoryJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("category",id));
    }
}
