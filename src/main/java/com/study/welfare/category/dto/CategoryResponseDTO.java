package com.study.welfare.category.dto;

import com.study.welfare.category.domain.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDTO {

    private String categoryName;

    public static CategoryResponseDTO from(Category category){
        return  CategoryResponseDTO.builder()
                .categoryName(category.getCategoryName())
                .build();
    }
}
