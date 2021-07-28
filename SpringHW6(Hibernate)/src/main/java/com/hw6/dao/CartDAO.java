package com.hw6.dao;

import com.hw6.entity.Cart;
import java.util.List;

public interface CartDAO{
    Cart getById(Long id);

    void save(Cart cart);

    void edit(Cart cart);

    void delete(Cart cart);

    List<Cart> findAll();
}
