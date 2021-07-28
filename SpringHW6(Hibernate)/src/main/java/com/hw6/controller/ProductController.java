package com.hw6.controller;

import com.hw6.entity.Product;
import com.hw6.service.CartService;
import com.hw6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/findProduct/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long productId){
        Product product = productService.findById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @GetMapping("/findAll")
    public List<Product> findAllProducts(){
        return productService.showAllProducts();
    }

    @PostMapping("/editProduct")
    public void editProduct(@RequestBody Product product){
        productService.editProduct(product);
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
    }
}
