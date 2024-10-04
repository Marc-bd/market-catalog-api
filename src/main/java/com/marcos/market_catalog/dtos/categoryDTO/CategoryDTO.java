package com.marcos.market_catalog.dtos.categoryDTO;

//String title, String description, String ownerId

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank(message = "required field")
     private String title;

    @NotBlank(message = "required field")
     private String description;

    @NotBlank(message = "required field")
     private String ownerId;



}
