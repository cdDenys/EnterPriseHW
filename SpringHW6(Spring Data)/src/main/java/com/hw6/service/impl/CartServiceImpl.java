package com.hw6.service.impl;

import com.hw6.entity.Cart;
import com.hw6.entity.Product;
import com.hw6.repository.CartRepository;
import com.hw6.service.CartService;
import com.hw6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Cart findById(Long id) {
        return cartRepository.getById(id);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void editCart(Cart cart) {
        saveCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> showAllCarts() {
        return cartRepository.findAll();
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
