package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;

import java.util.List;

public interface CartService {
    void createCart(Integer cartId, List<Product> productList, List<Cart> cartList);

    Cart getCart(Integer cartId, List<Cart> cartList);

    List<Cart> getAllCarts(List<Cart> cartList);

    void editCart(List<Cart> cartList, Integer cartId, List<Product> productList);

    void deleteCart(List<Cart> cartList, Integer cartId);

    Double getCartPrice(List<Product> productList);
}
