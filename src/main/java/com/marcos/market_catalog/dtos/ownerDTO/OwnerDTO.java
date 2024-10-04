package com.marcos.market_catalog.dtos.ownerDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class OwnerDTO {

    @NotBlank(message = "required field")
    private String name;

    @NotBlank(message = "required field")
    @Email(message = "invalid email")
    private String email;
}
