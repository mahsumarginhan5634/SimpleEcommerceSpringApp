package com.example.demo.service.impl;


import com.example.demo.entity.BasketProduct;
import com.example.demo.repository.BasketProductRepository;
import com.example.demo.service.BasketProductService;
import org.springframework.stereotype.Service;

@Service
public class BasketProductServiceImpl implements  BasketProductService{

    private final BasketProductRepository basketProductRepository;

    public BasketProductServiceImpl(BasketProductRepository basketProductRepository) {
        this.basketProductRepository = basketProductRepository;
    }


    @Override
    public BasketProduct save(BasketProduct basketProduct) {
        return basketProductRepository.save(basketProduct);
    }
}
