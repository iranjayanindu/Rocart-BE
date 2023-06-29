package com.lk.sliit.rocart.service.impl;



import com.lk.sliit.rocart.exception.NotFoundException;
import com.lk.sliit.rocart.model.Seller;
import com.lk.sliit.rocart.repository.SellerRepository;
import com.lk.sliit.rocart.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public Seller add(Seller seller) {

        if (seller.getName().length() < 1) {
            return null;
        } else {
            return sellerRepository.save(seller);
        }
    }

    @Override
    public void deleteById(int id) {
        getById(id);
        sellerRepository.deleteById(id);
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getById(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.orElseThrow(() -> new NotFoundException("seller couldn't be found by following id: " + id));
    }
}