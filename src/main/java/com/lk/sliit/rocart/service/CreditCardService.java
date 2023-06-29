package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAll();
    CreditCard add(CreditCard creditCard);
    List<CreditCard> getCreditCardByUserId(int id);
    CreditCard getBydId(int id);
}
