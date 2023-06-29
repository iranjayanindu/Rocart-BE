package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.model.Seller;

import java.util.List;

public interface SellerService {
    Seller add(Seller seller);
    void deleteById(int id);
    List<Seller> getAll();
    Seller getById(int id);
}
