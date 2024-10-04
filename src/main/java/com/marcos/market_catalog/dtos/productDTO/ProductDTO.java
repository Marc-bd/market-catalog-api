package com.marcos.market_catalog.dtos.productDTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    @NotBlank(message = "required field")
    private String title;

    @NotBlank(message = "required field")
    private String description;

    @NotBlank(message = "required field")
    private String ownerId;

    @NotNull(message = "required field")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotBlank(message = "required field")
    private String categoryId;


}
