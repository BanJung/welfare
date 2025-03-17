package com.study.welfare.groupfundingproduct.application.repository;

import com.study.welfare.groupfundingproduct.domain.GroupFundingProduct;

public interface GroupFundingProductRepository {
    void save(GroupFundingProduct groupFundingProduct);

    GroupFundingProduct findById(Long id);

    void updateParticipation(GroupFundingProduct groupFundingProduct);

}
