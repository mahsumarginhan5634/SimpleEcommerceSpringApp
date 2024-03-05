package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;

import java.util.Optional;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    Optional<Category> findById(Integer categoryId);
}
