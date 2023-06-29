package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.model.SellerComment;

import java.util.List;

public interface SellerCommentService {
    SellerComment add(SellerComment sellerComment);
    void deleteById(int id);
    List<SellerComment> getAll();
    SellerComment getById(int id);
    List<SellerComment> getSellerCommentsBySeller(int id);
}
