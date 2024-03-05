package com.example.demo.service.impl;

import com.example.demo.converters.BasketConvertor;
import com.example.demo.dto.BasketDto;
import com.example.demo.entity.Basket;
import com.example.demo.entity.BasketProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.BasketRepository;
import com.example.demo.service.BasketProductService;
import com.example.demo.service.BasketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {


    private final Integer STATUS_ACTIVE = 0;
    private final UserServiceImpl userService;
    private final BasketRepository basketRepository;
    private final BasketProductServiceImpl basketProductService;
    private final ProductServiceImpl productService;
    private final BasketConvertor basketConvertor;

    public BasketServiceImpl(UserServiceImpl userService, BasketRepository basketRepository, BasketProductServiceImpl basketProductService, ProductServiceImpl productService, BasketConvertor basketConvertor) {
        this.userService = userService;
        this.basketRepository = basketRepository;
        this.basketProductService = basketProductService;
        this.productService = productService;
        this.basketConvertor = basketConvertor;
    }


    @Override
    public BasketDto save(BasketDto basketDto) {
        Optional<User> user = userService.findById(basketDto.getUserId());

        if(user.isEmpty()){
            throw new NoSuchElementException("Kullanıcı bulunamadı");
        }

        Optional<Basket> basket = basketRepository.findBasketByUserIdAndStatus(basketDto.getUserId(),STATUS_ACTIVE);
        Optional<Product> product = productService.findById(basketDto.getProductId());
        if(basket.isEmpty()){
            return basketNotExist(user.get(),basketDto,product.get());
        }
        else {
            return basketExist(basket.get(),user.get(),basketDto,product.get());
        }
        

    }

    private BasketDto basketNotExist(User user, BasketDto basketDto,Product product) {
        Basket basket = new Basket();

        basket.setStatus(STATUS_ACTIVE);
        basket.setUser(user);
        basket.setTotalItem(basketDto.getCount());
        basket.setTotalPrice(basketDto.getCount() * product.getUnitPrice());
        basket = basketRepository.save(basket);

        List<BasketProduct> basketProductList = new ArrayList<>();
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBasket(basket);
        basketProduct.setProduct(product);
        basketProduct.setTotalPrice(basket.getTotalPrice());
        basketProduct.setItemAmount(basket.getTotalItem());
        basketProduct = basketProductService.save(basketProduct);

        basketProductList.add(basketProduct);
        basket.setBasketProductList(basketProductList);

        return basketConvertor.fromEntityToDto(basket);
    }

    private BasketDto basketExist(Basket basket, User user, BasketDto basketDto, Product product) {

        List<BasketProduct> basketProductList = basket.getBasketProductList();
        boolean productIsExistInBasketProduct = false;
        for(BasketProduct basketProduct : basketProductList){
            if(basketProduct.getProduct().getId() == basketDto.getProductId()){
                basketProduct.setItemAmount(basketProduct.getItemAmount() + basketDto.getCount());
                basketProduct.setTotalPrice(basketProduct.getTotalPrice() + (basketDto.getCount() * product.getUnitPrice()));
                productIsExistInBasketProduct = true;
                break;
            }
        }

        if(!productIsExistInBasketProduct){
            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setBasket(basket);
            basketProduct.setProduct(product);
            basketProduct.setTotalPrice(basketDto.getCount() * product.getUnitPrice());
            basketProduct.setItemAmount(basketDto.getCount());
            basketProduct = basketProductService.save(basketProduct);
            basketProductList.add(basketProduct);
            basket.setBasketProductList(basketProductList);
        }

        basket.setTotalItem(basketProductList.stream().mapToInt(BasketProduct::getItemAmount).sum());
        basket.setTotalPrice(basketProductList.stream().mapToDouble(BasketProduct::getTotalPrice).sum());
        basket = basketRepository.save(basket);

        return basketConvertor.fromEntityToDto(basket);

    }




}
