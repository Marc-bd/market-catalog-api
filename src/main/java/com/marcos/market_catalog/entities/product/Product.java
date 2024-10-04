package com.marcos.market_catalog.entities.product;

import com.marcos.market_catalog.dtos.productDTO.ProductDTO;
import com.marcos.market_catalog.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private BigDecimal price;

    private Category category;


    public Product(ProductDTO product) {
            this.title = product.getTitle();
            this.description = product.getDescription();
            this.ownerId = product.getOwnerId();
            this.price = product.getPrice();
    }

}
