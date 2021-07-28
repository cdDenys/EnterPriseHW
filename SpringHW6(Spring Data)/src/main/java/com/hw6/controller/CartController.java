package com.hw6.controller;

import com.hw6.entity.Cart;
import com.hw6.entity.Product;
import com.hw6.service.CartService;
import com.hw6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/findCartById/{id}")
    public ResponseEntity<Cart> findCartById(@PathVariable("id") long cartId){
        Cart cart = cartService.findById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createCart(){
        Cart cart = new Cart();
        cart.setProducts(productService.showAllProducts());
        cart.setCartPrice(cartService.getCartPrice(productService.showAllProducts()));
        cartService.saveCart(cart);
    }

    @GetMapping("/findAllCarts")
    public List<Cart> getAllCarts(){
        return cartService.showAllCarts();
    }

    @PostMapping("/editCart")
    public void editCart(@RequestBody Cart cart){
        cart.setProducts(productService.showAllProducts());
        cart.setCartPrice(cartService.getCartPrice(productService.showAllProducts()));
        cartService.editCart(cart);
    }

    @PostMapping("/deleteCart")
    public void deleteCart(@RequestBody Cart cart){
        cartService.deleteCart(cart);
    }


}
