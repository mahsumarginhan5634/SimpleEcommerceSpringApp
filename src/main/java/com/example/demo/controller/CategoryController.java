package com.example.demo.controller;

import com.example.demo.converters.CategoryConvertor;
import com.example.demo.request.CategoryRequest;
import com.example.demo.response.CategoryResponse;
import com.example.demo.service.CategoryService;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;
    private final CategoryConvertor categoryConvertor;


    public CategoryController(CategoryServiceImpl categoryService,CategoryConvertor categoryConvertor){
        this.categoryService = categoryService;
        this.categoryConvertor = categoryConvertor;
    }

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest categoryRequest){
        return categoryConvertor.fromDtoToResponse(categoryService.save(categoryConvertor.fromRequestToDto(categoryRequest)));
    }

}
