package com.example.demo.controller;

import com.example.demo.converters.ProductConvertor;
import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductConvertor productConvertor;

    public ProductController(ProductServiceImpl productService,ProductConvertor productConvertor){
        this.productService = productService;
        this.productConvertor = productConvertor;
    }

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest){
        return productConvertor.fromDtoToResponse(productService.save(productConvertor.fromRequestToDto(productRequest)));
    }

}
