package com.hw6.service;

import com.hw6.entity.Cart;
import com.hw6.entity.Product;

import java.util.List;

public interface CartService {

    Cart findById(Long id);

    void saveCart(Cart cart);

    void editCart(Cart cart);

    void deleteCart(Cart cart);

    List<Cart> showAllCarts();

    Double getCartPrice(List<Product> products);
}
