package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.util.Optional;


public interface ProductService {

    ProductDto save(ProductDto productDto);

    Optional<Product> findById(Integer productId);
}
