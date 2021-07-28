package com.hw6.dao;

import com.hw6.entity.Product;

import java.util.List;

public interface ProductDAO {

     Product getById(Long id);

     void save(Product product);

     void edit(Product product);

     void delete(Product product);

     List<Product> findAll();
}
