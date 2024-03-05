package com.example.demo.response;

import com.example.demo.dto.BasketProductDto;
import com.example.demo.entity.BasketProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {
    private Integer id;
    private Integer status;
    private Integer totalItem;
    private Double totalPrice;
    private Integer userId;
    private List<BasketProductDto> basketProductList;
}
