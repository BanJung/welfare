package com.study.welfare.category.presentation;

import com.study.welfare.category.application.CategoryService;
import com.study.welfare.category.dto.CategoryRequestDTO;
import com.study.welfare.category.dto.CategoryResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Category", description = "Category API")
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO requestDto) {
        CategoryResponseDTO responseDto = categoryService.saveCategory(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findCategoryById(@PathVariable int id){
        CategoryResponseDTO responseDTO = categoryService.findCategoryById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping
    public Page<CategoryResponseDTO> getCategories(Pageable pageable) {
        return categoryService.getCategories(pageable);
    }

}
