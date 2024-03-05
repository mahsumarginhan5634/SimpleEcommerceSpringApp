package com.example.demo.converters;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.request.CategoryRequest;
import com.example.demo.response.CategoryResponse;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConvertor {




    //veritabanına doğru giden yol
    public CategoryDto fromRequestToDto(CategoryRequest categoryRequest){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryRequest.getName());
        categoryDto.setDescription(categoryRequest.getDescription());
        return categoryDto;
    }

    //veritabanından gelen yol
    public CategoryDto fromEntityToDto(Category category){

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());

        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> productList = category.getProductList();

        if(productList != null){
            for(Product product : productList){
                ProductDto productDto = new ProductDto();
                productDto.setId(product.getId());
                productDto.setName(product.getName());
                productDto.setDescription(product.getDescription());
                productDto.setUnitPrice(product.getUnitPrice());
                productDto.setCategoryId(category.getId());
                productDtoList.add(productDto);
            }

            categoryDto.setProductList(productDtoList);
        }

        return categoryDto;
    }

    //veritabanına doğru giden yol
    public Category fromDtoToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    //veritabanından gelen yol
    public CategoryResponse fromDtoToResponse(CategoryDto categoryDto){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(categoryDto.getId());
        categoryResponse.setDescription(categoryDto.getDescription());
        categoryResponse.setName(categoryDto.getName());
        categoryResponse.setProductList(categoryDto.getProductList());
        return categoryResponse;
    }
}
