package com.example.demo.dto;

import com.example.demo.entity.BasketProduct;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {
    private Integer id;
    private Integer status;
    private Integer totalItem;
    private Double totalPrice;
    private Integer userId;
    private Integer count;
    private Integer productId;
    private List<BasketProductDto> basketProductDtoList;
}
