package com.hw6.service;

import com.hw6.entity.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    void saveProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> showAllProducts();

}
