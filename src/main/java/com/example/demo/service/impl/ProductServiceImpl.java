package com.example.demo.service.impl;

import com.example.demo.converters.ProductConvertor;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductConvertor productConvertor;

    public ProductServiceImpl(ProductRepository productRepository,ProductConvertor productConvertor){
        this.productRepository = productRepository;
        this.productConvertor = productConvertor;
    }

    @Override
    public ProductDto save(ProductDto productDto) {

        Product product = productRepository.findProductByNameAndDescriptionAndAndCategory_Id(
                                                productDto.getName(),
                                                productDto.getDescription(),
                                                productDto.getCategoryId());

        if(product == null){
            return productConvertor.fromEntityToDto(productRepository.save(productConvertor.fromDtoToEntity(productDto)));
        }

        return productConvertor.fromEntityToDto(product);
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }
}
