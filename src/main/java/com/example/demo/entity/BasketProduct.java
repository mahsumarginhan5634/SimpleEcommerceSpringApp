package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double totalPrice;
    private Integer itemAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basketId",referencedColumnName ="id")
    @JsonManagedReference(value = "basketProduct-basket")
    private Basket basket;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",referencedColumnName = "id")
    @JsonManagedReference(value = "basketProduct-product")
    private Product product;
}
