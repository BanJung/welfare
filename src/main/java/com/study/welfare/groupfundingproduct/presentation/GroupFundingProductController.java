package com.study.welfare.groupfundingproduct.presentation;

import com.study.welfare.groupfundingproduct.application.GroupFundingProductService;
import com.study.welfare.groupfundingproduct.core.dto.GroupFundingProductRequestDTO;
import com.study.welfare.groupfundingproduct.core.dto.GroupFundingProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/group-funding-products")
@RequiredArgsConstructor
public class GroupFundingProductController {

    private final GroupFundingProductService groupFundingProductService;

    // 공동 구매 상품 저장
    @PostMapping
    public ResponseEntity<GroupFundingProductResponseDTO> createGroupFundingProduct(@RequestBody GroupFundingProductRequestDTO requestDto) {
        GroupFundingProductResponseDTO responseDto = groupFundingProductService.saveGroupFundingProduct(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PostMapping("/{productId}/participate")
    public void participate(@PathVariable Long productId) {
        groupFundingProductService.participate(productId);
    }

    @PostMapping("/{productId}/cancel")
    public void cancelParticipation(@PathVariable Long productId) {
        groupFundingProductService.cancelParticipation(productId);
    }
}


