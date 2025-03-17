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

    public CategoryJpaEntity(String categoryName) {
        this.id=getId();
        this.name=categoryName;
    }

    public static CategoryJpaEntity from(Category category){
        return new CategoryJpaEntity(
                category.getCategoryName()
        );
    }

    public Category toModel(){
        return Category.builder()
                .categoryId(getId())
                .categoryName(getName())
                .build();
    }
}
