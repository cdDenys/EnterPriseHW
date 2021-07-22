package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest {
    private List<Product> productListTest;

    List<Product> productList = new ArrayList<>();
    ProductService productService = new ProductServiceImpl();

    @Test
    public void createProduct() {
        productService.createProduct("Tea", 5.59, productList);
        Product product = new Product();
        product.setProductName("Tea");
        product.setPrice(5.59);
        assertEquals(productService.getProduct("Tea", productList).getProductName(), product.getProductName());
        assertEquals(productService.getProduct("Tea", productList).getPrice(), product.getPrice());
    }

    @Test
    public void getProduct_Bad() {
        Product product = new Product();
        product.setProductName("Tea");
        product.setPrice(5.59);
        assertNull(productService.getProduct("Tea", productList).getPrice());
        assertNull(productService.getProduct("Tea", productList).getProductName());
    }

    @Test
    public void getAllProducts_Bad() {
       assertNull(productService.getAllProducts(productListTest));
    }

    @Test
    public void editProduct() {
        productService.createProduct("Coffee", 29.99, productList);
        productService.editProduct("Coffee", "Milk", 2.45, productList);

        Product product = new Product();
        product.setProductName("Milk");
        product.setPrice(2.45);
        assertEquals(productService.getProduct("Milk", productList).getProductName(), product.getProductName());
        assertEquals(productService.getProduct("Milk", productList).getPrice(), product.getPrice());
    }

    @Test
    public void deleteProduct() {
        productService.createProduct("Potato", 1.99, productList);
        productService.deleteProduct("Potato", productList);
        assertEquals(productList.size(), 0);
    }

}