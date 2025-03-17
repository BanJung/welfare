package com.study.welfare.reproduct.presentation;

import com.study.welfare.reproduct.application.ReProductService;
import com.study.welfare.reproduct.core.dto.ReProductRequestDTO;
import com.study.welfare.reproduct.core.dto.ReProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/re-products")
@RequiredArgsConstructor
public class ReProductController {

    private final ReProductService reProductService;

    // 중고 상품 저장(등록)
    @PostMapping
    public ResponseEntity<ReProductResponseDTO> createReProduct(@RequestBody ReProductRequestDTO requestDto) {
        ReProductResponseDTO responseDto = reProductService.saveReProduct(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
