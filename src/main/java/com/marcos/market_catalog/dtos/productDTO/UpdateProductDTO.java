package com.marcos.market_catalog.dtos.productDTO;

import java.math.BigDecimal;

public record UpdateProductDTO(String title, String description, BigDecimal price , String categoryId) {
}
