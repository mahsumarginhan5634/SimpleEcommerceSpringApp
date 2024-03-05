package com.example.demo.converters;

import com.example.demo.dto.BasketProductDto;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.BasketProduct;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConvertor {

    private final CategoryServiceImpl categoryService;

    public ProductConvertor(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    public ProductDto fromEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setCategoryId(product.getCategory().getId());

        List<BasketProductDto> basketProductDtoList = new ArrayList<>();
        List<BasketProduct> basketProductList = product.getBasketProductList();
        if(basketProductList != null){

            for(BasketProduct basketProduct : basketProductList){
                BasketProductDto basketProductDto = new BasketProductDto();
                basketProductDto.setId(basketProduct.getId());
                basketProductDto.setTotalPrice(basketProduct.getTotalPrice());
                basketProductDto.setItemAmount(basketProduct.getItemAmount());
                basketProductDto.setProductId(product.getId());
                basketProductDto.setBasketId(basketProduct.getBasket().getId());
                basketProductDtoList.add(basketProductDto);
            }

            productDto.setBasketProductDtoList(basketProductDtoList);
        }

        return productDto;
    }

    public Product fromDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setUnitPrice(productDto.getUnitPrice());
        Category category = categoryService.findById(productDto.getCategoryId()).get();
        product.setCategory(category);

        return product;
    }

    public ProductDto fromRequestToDto(ProductRequest productRequest){
        ProductDto productDto = new ProductDto();
        productDto.setName(productRequest.getName());
        productDto.setDescription(productRequest.getDescription());
        productDto.setUnitPrice(productRequest.getUnitPrice());
        productDto.setCategoryId(productRequest.getCategoryId());
        return productDto;
    }

    public ProductResponse fromDtoToResponse(ProductDto productDto){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productDto.getId());
        productResponse.setName(productDto.getName());
        productResponse.setDescription(productDto.getDescription());
        productResponse.setUnitPrice(productDto.getUnitPrice());
        productResponse.setCategoryId(productDto.getCategoryId());
        productResponse.setBasketProductDtoList(productDto.getBasketProductDtoList());
        return productResponse;
    }
}
