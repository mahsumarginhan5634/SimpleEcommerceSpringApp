package com.example.demo.response;

import com.example.demo.dto.BasketProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Double unitPrice;
    private Integer categoryId;
    private List<BasketProductDto> basketProductDtoList ;
}
