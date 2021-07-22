package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public void createCart(Integer cartId, List<Product> productList, List<Cart> cartList) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setProductList(productList);
        cart.setCartPrice(getCartPrice(productList));
        cartList.add(cart);
    }

    @Override
    public Cart getCart(Integer cartId, List<Cart> cartList) {
        Cart cart = new Cart();
        for (Cart value : cartList) {
            if (value.getCartId().equals(cartId)) {
                cart = value;
            }
        }
        return cart;
    }

    @Override
    public List<Cart> getAllCarts(List<Cart> cartList) {
        return cartList;
    }

    @Override
    public void editCart(List<Cart> cartList, Integer cartId, List<Product> productList) {
            if (cartList.toString().contains(productList.toString())){
                cartList.removeIf(item -> item.getCartId().equals(cartId));
                createCart(cartId, productList, cartList);
            }else {
                System.out.println("Cart not found");
            }

    }

    @Override
    public void deleteCart(List<Cart> cartList, Integer cartId) {
        cartList.removeIf(item -> item.getCartId().equals(cartId));
    }

    @Override
    public Double getCartPrice(List<Product> productList) {
        Double price = 0.0;
        for (Product product : productList) {
            price += product.getPrice();
        }
        return price;
    }
}
