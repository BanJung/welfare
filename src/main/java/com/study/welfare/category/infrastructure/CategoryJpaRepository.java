package com.study.welfare.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Integer> {
    @Query("SELECT c FROM CategoryJpaEntity c ORDER BY c.name ASC")
    Page<CategoryJpaEntity> findAllSortedByName(Pageable pageable);
}
