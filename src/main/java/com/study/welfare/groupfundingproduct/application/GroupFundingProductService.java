package com.study.welfare.groupfundingproduct.application;

import com.study.welfare.category.application.repository.CategoryRepository;
import com.study.welfare.groupfundingproduct.application.repository.GroupFundingProductRepository;
import com.study.welfare.groupfundingproduct.core.dto.GroupFundingProductRequestDTO;
import com.study.welfare.groupfundingproduct.core.dto.GroupFundingProductResponseDTO;
import com.study.welfare.groupfundingproduct.domain.GroupFundingProduct;
import com.study.welfare.product.application.ProductService;
import com.study.welfare.product.application.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupFundingProductService {

    private final GroupFundingProductRepository groupFundingProductRepository;

    @Transactional
    public GroupFundingProductResponseDTO saveGroupFundingProduct(GroupFundingProductRequestDTO requestDTO) {

        // GroupFundingProduct 객체 생성
        GroupFundingProduct groupFundingProduct = GroupFundingProduct.createFromRequestDTO(requestDTO);

        // ReProduct 저장
        groupFundingProductRepository.save(groupFundingProduct);

        return GroupFundingProductResponseDTO.from(groupFundingProduct);
    }

    @Transactional
    public void participate(Long productId) {
        GroupFundingProduct product = groupFundingProductRepository.findById(productId);
        product.getParticipantCount().increase();
        groupFundingProductRepository.updateParticipation(product);
    }

    @Transactional
    public void cancelParticipation(Long productId) {
        GroupFundingProduct product = groupFundingProductRepository.findById(productId);
        product.getParticipantCount().decrease();
        groupFundingProductRepository.updateParticipation(product);
    }



}
