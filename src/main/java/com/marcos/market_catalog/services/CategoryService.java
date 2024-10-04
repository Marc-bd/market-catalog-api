package com.marcos.market_catalog.services;

import com.marcos.market_catalog.dtos.categoryDTO.UpdateCategoryDTO;
import com.marcos.market_catalog.entities.category.Category;
import com.marcos.market_catalog.dtos.categoryDTO.CategoryDTO;
import com.marcos.market_catalog.entities.owner.Owner;
import com.marcos.market_catalog.exceptions.ObjectNotFoundException;
import com.marcos.market_catalog.repositories.CategoryRepository;
import com.marcos.market_catalog.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private OwnerRepository ownerRepository;
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository, OwnerRepository ownerRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
    }

    public Category create(CategoryDTO categoryData) {
        Owner owner = ownerRepository.findById(categoryData.getOwnerId()).orElseThrow(() -> new ObjectNotFoundException("Owner not found with id: " + categoryData.getOwnerId()));

        Category category = new Category(categoryData);
        return repository.save(category);
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category getById(String id) {
        return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("category not found with id: " + id));
    }

    public Category update(String id, UpdateCategoryDTO categoryData) {
        Category category = this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("category not found with id: " + id));

        System.out.println("category: " + categoryData);

        if (categoryData.title() != null && !categoryData.title().isEmpty()) {
            System.out.println("bateu");
            category.setTitle(categoryData.title());
        }

        if (categoryData.description() != null && !categoryData.description().isEmpty()) {
            category.setDescription(categoryData.description());
        }

        this.repository.save(category);

        return category;

    }

    public void delete(String id) {
        Category category = this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("category not found with id: " + id));
        this.repository.delete(category);
    }

}
