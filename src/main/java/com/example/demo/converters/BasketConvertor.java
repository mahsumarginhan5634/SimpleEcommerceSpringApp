package com.example.demo.converters;

import com.example.demo.dto.BasketDto;
import com.example.demo.dto.BasketProductDto;
import com.example.demo.entity.Basket;
import com.example.demo.entity.BasketProduct;
import com.example.demo.request.BasketRequest;
import com.example.demo.response.BasketResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketConvertor {

    public BasketDto fromRequestToDto(BasketRequest basketRequest){
        BasketDto basketDto = new BasketDto();
        basketDto.setCount(basketRequest.getCount());
        basketDto.setProductId(basketRequest.getProductId());
        basketDto.setUserId(basketRequest.getUserId());
        return basketDto;
    }


    public BasketResponse fromDtoToResponse(BasketDto basketDto){
        BasketResponse response = new BasketResponse();
        response.setId(basketDto.getId());
        response.setStatus(basketDto.getStatus());
        response.setTotalItem(basketDto.getTotalItem());
        response.setTotalPrice(basketDto.getTotalPrice());
        response.setUserId(basketDto.getUserId());
        response.setBasketProductList(basketDto.getBasketProductDtoList());
        return response;
    }

    public BasketDto fromEntityToDto(Basket basket) {
        BasketDto basketDto = new BasketDto();
        basketDto.setId(basket.getId());
        basketDto.setStatus(basket.getStatus());
        basketDto.setTotalItem(basket.getTotalItem());
        basketDto.setTotalPrice(basket.getTotalPrice());
        basketDto.setUserId(basket.getUser().getId());
        List<BasketProduct> basketProductList = basket.getBasketProductList();
        List<BasketProductDto> basketProductDtoList = new ArrayList<>();
        for(BasketProduct basketProduct : basketProductList){
            BasketProductDto basketProductDto = new BasketProductDto();
            basketProductDto.setId(basketProduct.getId());
            basketProductDto.setTotalPrice(basketProduct.getTotalPrice());
            basketProductDto.setItemAmount(basketProduct.getItemAmount());
            basketProductDto.setProductId(basketProduct.getProduct().getId());
            basketProductDto.setBasketId(basketProduct.getBasket().getId());
            basketProductDtoList.add(basketProductDto);
        }
        basketDto.setBasketProductDtoList(basketProductDtoList);

        return basketDto;

    }
}
