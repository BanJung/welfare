package com.study.welfare.reproduct.application;

import com.study.welfare.reproduct.application.repository.ReProductRepository;
import com.study.welfare.reproduct.core.dto.ReProductRequestDTO;
import com.study.welfare.reproduct.core.dto.ReProductResponseDTO;
import com.study.welfare.reproduct.domain.ReProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReProductService {

    private final ReProductRepository reProductRepository;

    @Transactional
    public ReProductResponseDTO saveReProduct(ReProductRequestDTO requestDTO) {
        // ReProduct 객체 생성
        ReProduct reProduct = ReProduct.createFromRequestDTO(requestDTO);

        // ReProduct 저장
        reProductRepository.save(reProduct);

        return ReProductResponseDTO.from(reProduct);
    }


}
