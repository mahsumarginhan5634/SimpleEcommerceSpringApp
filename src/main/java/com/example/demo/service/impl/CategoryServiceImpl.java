package com.example.demo.service.impl;

import com.example.demo.converters.CategoryConvertor;
import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConvertor categoryConvertor;

    public CategoryServiceImpl(CategoryRepository categoryRepository,CategoryConvertor categoryConvertor){
        this.categoryRepository = categoryRepository;
        this.categoryConvertor = categoryConvertor;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        Category category = categoryRepository.findCategoryByNameAndDescription(categoryDto.getName(),categoryDto.getDescription());
        if(category == null){
            return categoryConvertor.fromEntityToDto(categoryRepository.save(categoryConvertor.fromDtoToEntity(categoryDto)));
        }

        return categoryConvertor.fromEntityToDto(category);
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
