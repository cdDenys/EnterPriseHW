package com.hw6.service.impl;

import com.hw6.dao.impl.CartDAOImpl;
import com.hw6.entity.Cart;
import com.hw6.entity.Product;
import com.hw6.dao.CartDAO;
import com.hw6.service.CartService;
import com.hw6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    CartDAO cartDAO = new CartDAOImpl();

    @Autowired
    private ProductService productService;

    @Override
    public Cart findById(Long id) {
        return cartDAO.getById(id);
    }

    @Override
    public void saveCart(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public void editCart(Cart cart) {
        saveCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartDAO.delete(cart);
    }

    @Override
    public List<Cart> showAllCarts() {
        return cartDAO.findAll();
    }

    @Override
    public Double getCartPrice(List<Product> products) {
        double cartPrice = 0;
        for (Product product : products) {
            if (product != null) {
                cartPrice += product.getProductPrice();
            }
        }
        return cartPrice;
    }
}
