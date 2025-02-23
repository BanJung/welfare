package com.study.welfare.category.application.repository;

import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryRepository {

    void save(Category category);
    Category findById(Integer id);
    Page<Category> findAllSortedByName(Pageable pageable);
    CategoryJpaEntity findEntityById(Integer id);
}
