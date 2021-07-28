package com.hw6.service.impl;

import com.hw6.dao.impl.ProductDAOImpl;
import com.hw6.entity.Product;
import com.hw6.dao.ProductDAO;
import com.hw6.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public Product findById(Long id) {
        return productDAO.getById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public void editProduct(Product product) {
        saveProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    @Override
    public List<Product> showAllProducts() {
        return productDAO.findAll();
    }

}
