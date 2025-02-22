package com.study.welfare.category.application.repository;

import com.study.welfare.category.domain.Category;
import com.study.welfare.category.infrastructure.CategoryJpaEntity;


public interface CategoryRepository {

    void save(Category category);
    Category findById(Integer id);

    CategoryJpaEntity findEntityById(Integer id);
}
