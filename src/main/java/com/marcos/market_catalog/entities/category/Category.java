package com.marcos.market_catalog.entities.category;

import com.marcos.market_catalog.dtos.categoryDTO.CategoryDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public Category(CategoryDTO category) {
        this.title = category.getTitle();
        this.description = category.getDescription();
        this.ownerId = category.getOwnerId();
    }

}
