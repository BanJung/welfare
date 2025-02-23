package com.study.welfare.category.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.category.dto.CategoryRequestDTO;
import com.study.welfare.category.dto.CategoryResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryResponseDTO saveCategory(CategoryRequestDTO requestDto){
        Category category=Category.createFromRequestDTO(requestDto);
        categoryRepository.save(category);
        return CategoryResponseDTO.from(category);
    }

    public CategoryResponseDTO findCategoryById(int id) {
        return CategoryResponseDTO.from(categoryRepository.findById(id));
    }

    public Page<CategoryResponseDTO> getCategories(Pageable pageable) {
        return categoryRepository.findAllSortedByName(pageable).map(CategoryResponseDTO::from);
    }

}
