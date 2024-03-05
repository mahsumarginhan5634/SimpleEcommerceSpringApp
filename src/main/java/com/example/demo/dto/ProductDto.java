package com.example.demo.dto;

import com.example.demo.entity.BasketProduct;
import com.example.demo.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Double unitPrice;
    private Integer categoryId;
    private List<BasketProductDto> basketProductDtoList ;
}
