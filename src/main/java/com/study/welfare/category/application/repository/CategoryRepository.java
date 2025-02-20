package com.study.welfare.category.application.repository;

import com.study.welfare.category.domain.Category;


public interface CategoryRepository {

    void save(Category category);
    Category findById(int id);
}
