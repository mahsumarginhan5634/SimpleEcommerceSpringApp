package com.example.demo.repository;

import com.example.demo.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    Basket save(Basket basket);
    Optional<Basket> findBasketByUserIdAndStatus(Integer userId, Integer status);
}
