package com.example.demo.controller;


import com.example.demo.model.Cart;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.service.CartService;
import com.example.demo.service.PersonService;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.CartServiceImpl;
import com.example.demo.service.impl.PersonServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {

    ProductService productService = new ProductServiceImpl();
    List<Product> productList = new ArrayList<>();
    CartService cartService = new CartServiceImpl();
    List<Cart> cartList = new ArrayList<>();
    PersonService personService = new PersonServiceImpl();
    List<Person> personList = new ArrayList<>();


    @PostMapping(value = "/product/add")
    public void addProduct(@RequestParam(name = "productName")
                                   String productName, @RequestParam(name = "price") Double price) {
        productService.createProduct(productName, price, productList);
    }

    @GetMapping("/product/show")
    public List<Product> getAllProducts() {
        return productList;
    }

    @GetMapping(value = "/product/show/item")
    public Product getProduct(@RequestParam(name = "productName") String productName) {
        return productService.getProduct(productName, productList);
    }

    @PostMapping(value = "/product/delete")
    public void deleteProduct(@RequestParam(name = "productName") String productName) {
        productService.deleteProduct(productName, productList);
    }

    @PostMapping(value = "/product/edit")
    public void editProduct(@RequestParam(name = "findProduct") String findProductName,
                            @RequestParam(name = "newProduct") String newProductName,
                            @RequestParam(name = "newPrice") Double newProductPrice) {
        productService.editProduct(findProductName, newProductName, newProductPrice, productList);
    }

    @PostMapping(value = "/cart/add")
    public void createCart(@RequestParam(name = "cartId") Integer cartId) {
        cartService.createCart(cartId, productService.getAllProducts(productList), cartList);
    }

    @GetMapping("/cart/show")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts(cartList);
    }

    @GetMapping("/cart/show/item")
    public Cart getCart(@RequestParam(name = "cartId") Integer cartId) {
        return cartService.getCart(cartId, cartList);
    }

    @PostMapping("/cart/edit")
    public void editCart(@RequestParam(name = "cartId") Integer cartId){
        cartService.editCart(cartList, cartId, productService.getAllProducts(productList));
    }

    @PostMapping("/cart/delete")
    public void deleteCart (@RequestParam(name = "cartId") Integer cartId){
        cartService.deleteCart(cartList, cartId);
    }

    @PostMapping("/person/add")
    public void createPerson(@RequestParam(name = "personName") String name,
                             @RequestParam(name = "cartId") Integer cartId){
        personService.createPerson(name, cartId, personList, cartList);
    }

    @GetMapping("/person/show/item")
    public Person getPerson(@RequestParam(name = "name") String name){
        return personService.getPerson(name, personList);
    }

    @GetMapping("/person/show/all")
    public List<Person> getAllPeople(){
        return personService.getAllPeople(personList);
    }

    @PostMapping("/person/edit")
    public void editPerson(@RequestParam(name = "findPerson") String findPersonName,
                           @RequestParam(name = "newPersonName") String  newPersonName,
                           @RequestParam(name = "newCartId") Integer newCartId){
        personService.editPerson(findPersonName, newPersonName, newCartId, personList, cartList);
    }

    @PostMapping("/person/delete")
    public void deletePerson(@RequestParam(name = "name") String name){
        personService.deletePerson(name, personList);
    }

}
