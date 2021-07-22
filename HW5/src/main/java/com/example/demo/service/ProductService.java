package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(String productName, Double price, List<Product> productList);

    Product getProduct(String name, List<Product> productList);

    List<Product> getAllProducts(List<Product> productList);

    void editProduct(String findProductName, String newProductName, double newProductPrice, List<Product> productList);

    void deleteProduct(String productName, List<Product> productList);

}
