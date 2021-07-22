package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void createProduct(String productName, Double price, List<Product> productList) {
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        productList.add(product);
    }

    @Override
    public Product getProduct(String name, List<Product> productList) {
        Product product = new Product();
        for (Product value : productList) {
            if (value.getProductName().equals(name)) {
                product = value;
            }
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts(List<Product> productList) {
        return productList;
    }

    @Override
    public void editProduct(String findProductName, String newProductName, double newProductPrice, List<Product> productList) {
        if (productList.toString().contains(findProductName)) {
            productList.removeIf(item -> item.getProductName().equals(findProductName));
            createProduct(newProductName, newProductPrice, productList);
        }else {
            System.out.println("Product not found");
        }
    }

    @Override
    public void deleteProduct(String productName, List<Product> productList) {
        productList.removeIf(item -> item.getProductName().equals(productName));
    }
}
