package com.example.demo.controller;

import com.example.demo.converters.BasketConvertor;
import com.example.demo.request.BasketRequest;
import com.example.demo.response.BasketResponse;
import com.example.demo.service.impl.BasketServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final BasketServiceImpl basketService;
    private final BasketConvertor basketConvertor;
    public BasketController(BasketServiceImpl basketService,BasketConvertor basketConvertor){
        this.basketService = basketService;
        this.basketConvertor = basketConvertor;
    }

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basketRequest){
        return basketConvertor.fromDtoToResponse(basketService.save(basketConvertor.fromRequestToDto(basketRequest)));
    }
}
