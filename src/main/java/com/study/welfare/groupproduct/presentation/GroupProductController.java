package com.study.welfare.groupproduct.presentation;

import com.study.welfare.groupproduct.application.GroupProductService;
import com.study.welfare.groupproduct.core.dto.GroupProductRequestDTO;
import com.study.welfare.groupproduct.core.dto.GroupProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/group-products")
@RequiredArgsConstructor
public class GroupProductController {

    private final GroupProductService groupProductService;

    // 공동 구매 상품 저장
    @PostMapping
    public ResponseEntity<GroupProductResponseDTO> createGroupProduct(@RequestBody GroupProductRequestDTO requestDto) {
        GroupProductResponseDTO responseDto = groupProductService.saveGroupProduct(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}


