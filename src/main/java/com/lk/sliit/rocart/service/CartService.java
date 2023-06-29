package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.model.Cart;

import java.util.List;

public interface CartService {
    Cart getById(int id);
    void deleteById(int id);
    List<Cart> getAll();
    void add(Cart cart);
}
