package com.lk.sliit.rocart.controller;





import com.lk.sliit.rocart.model.Seller;
import com.lk.sliit.rocart.request.SellerCreateRequest;
import com.lk.sliit.rocart.service.SellerService;
import com.lk.sliit.rocart.shared.ECommerceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/seller/")
@RequiredArgsConstructor
@CrossOrigin
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(sellerService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody SellerCreateRequest seller) {
        sellerService.add(new Seller(seller.getName(), seller.getProfilePictureUrl(), seller.getEMail(), new Date()));
        return ResponseEntity.ok(ECommerceMessage.SELLER_SAVED);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        sellerService.deleteById(id);
        return ResponseEntity.ok(ECommerceMessage.SELLER_DELETED);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(sellerService.getById(id));
    }

}
