package com.marcos.market_catalog.services;

import com.marcos.market_catalog.dtos.productDTO.UpdateProductDTO;
import com.marcos.market_catalog.entities.category.Category;
import com.marcos.market_catalog.entities.product.Product;
import com.marcos.market_catalog.dtos.productDTO.ProductDTO;
import com.marcos.market_catalog.exceptions.ObjectNotFoundException;
import com.marcos.market_catalog.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product create(ProductDTO productData) {

        Category category = categoryService.getById(productData.getCategoryId());

        Product product = new Product(productData);

        product.setCategory(category);

        this.productRepository.save(product);

        return product;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product update(String id, UpdateProductDTO productData) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("product not found with id: " + id));

        if (productData.title() != null && !productData.title().isEmpty()) {
            product.setTitle(productData.title());
        }

        if (productData.description() != null && !productData.description().isEmpty()) {
            product.setDescription(productData.description());
        }

        if (productData.price() != null) {
            product.setPrice(productData.price());
        }

        if (productData.categoryId() != null && !productData.categoryId().isBlank()) {
            Category category = categoryService.getById(productData.categoryId());

            product.setCategory(category);
        }
        this.productRepository.save(product);

        return product;

    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("product not found with id: " + id));
        this.productRepository.delete(product);
    }


}
