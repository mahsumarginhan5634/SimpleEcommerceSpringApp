package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductDto {
    private Integer id;
    private Double totalPrice;
    private Integer itemAmount;
    private Integer productId;
    private Integer basketId;
}
