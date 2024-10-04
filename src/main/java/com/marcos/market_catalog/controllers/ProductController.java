package com.marcos.market_catalog.controllers;

import com.marcos.market_catalog.dtos.productDTO.UpdateProductDTO;
import com.marcos.market_catalog.entities.product.Product;
import com.marcos.market_catalog.dtos.productDTO.ProductDTO;
import com.marcos.market_catalog.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final View error;
    private ProductService productService;

    public ProductController(ProductService productService, View error) {
        this.productService = productService;
        this.error = error;
    }

    @PostMapping
    public ResponseEntity<Product> create(
            @Valid
            @RequestBody
            ProductDTO productData) {
        Product newProduct = this.productService.create(productData);
        return ResponseEntity.ok().body(newProduct);
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> listProducts = this.productService.getAll();
        return ResponseEntity.ok().body(listProducts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @Valid
            @PathVariable("id")
            String id,
            @RequestBody
            UpdateProductDTO productData) {
        Product updatedProduct = this.productService.update(id, productData);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @Valid
            @PathVariable("id")
            String id) {
        this.productService.delete(id);

        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("success", "product deleted successfully");

        return ResponseEntity.ok().body(errorResponse);
    }


}
