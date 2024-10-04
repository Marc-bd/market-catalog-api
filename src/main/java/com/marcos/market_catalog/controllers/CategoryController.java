package com.marcos.market_catalog.controllers;

import com.marcos.market_catalog.dtos.categoryDTO.UpdateCategoryDTO;
import com.marcos.market_catalog.entities.category.Category;
import com.marcos.market_catalog.dtos.categoryDTO.CategoryDTO;
import com.marcos.market_catalog.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid
                                           @RequestBody CategoryDTO categoryData) {
            Category newCategory = this.categoryService.create(categoryData);
            return ResponseEntity.ok().body(newCategory);
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> listCategories = this.categoryService.getAll();
        return ResponseEntity.ok().body(listCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@Valid @PathVariable("id") String id, @RequestBody
    UpdateCategoryDTO categoryData) {
        Category updatedCategory = this.categoryService.update(id, categoryData);
        return ResponseEntity.ok().body(updatedCategory);
    }

 @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@Valid @PathVariable("id") String id) {
       this.categoryService.delete(id);

       Map<String, String> errorMessage = new HashMap<>();
       errorMessage.put("success", "category deleted successfully");
        return ResponseEntity.ok().body(errorMessage);
    }


}
