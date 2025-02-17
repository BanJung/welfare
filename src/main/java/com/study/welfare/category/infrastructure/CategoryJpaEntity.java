package com.study.welfare.category.infrastructure;

import com.study.welfare.category.domain.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public static CategoryJpaEntity from(Category category){
        CategoryJpaEntity entity=new CategoryJpaEntity();
        entity.name=category.categoryName();
        return entity;
    }

    public Category toModel(){
        return Category.builder()
                .categoryName(this.name)
                .build();
    }
}
