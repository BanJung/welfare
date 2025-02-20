package com.study.welfare.groupproduct.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.category.domain.Category;
import com.study.welfare.groupproduct.application.repository.GroupProductRepository;
import com.study.welfare.groupproduct.core.dto.GroupProductRequestDTO;
import com.study.welfare.groupproduct.core.dto.GroupProductResponseDTO;
import com.study.welfare.groupproduct.domain.GroupProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupProductService {

    private final GroupProductRepository groupProductRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public GroupProductResponseDTO saveGroupProduct(GroupProductRequestDTO requestDto) {
        // Category 조회
        Category category = categoryRepository.findById(requestDto.getCategoryId());

        // GroupProduct 객체 생성
        GroupProduct groupProduct = GroupProduct.createFromRequestDTO(requestDto, category);

        // ReProduct 저장
        groupProductRepository.save(groupProduct);

        return GroupProductResponseDTO.from(groupProduct);
    }


}
