package com.study.welfare.category.application.repository;

import com.study.welfare.category.domain.Category;

public interface CategoryRepository {
    public Category findById(int id);
}
