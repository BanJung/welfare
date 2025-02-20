package com.study.welfare.category.domain;

import com.study.welfare.category.dto.CategoryRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class Category {
    private final int categoryId;
    private final String categoryName;
    public static Category createCategory(String categoryName) {
        return Category.builder()
                .categoryName(categoryName)
                .build();
    }

    public static Category createFromRequestDTO(CategoryRequestDTO categoryRequestDTO) {
        return Category.builder()
                .categoryName(categoryRequestDTO.getCategoryName())
                .build();
    }
}
