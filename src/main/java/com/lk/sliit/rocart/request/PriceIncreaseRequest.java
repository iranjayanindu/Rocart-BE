package com.lk.sliit.rocart.request;

import lombok.Data;

@Data
public class PriceIncreaseRequest {

    private int productId;

    private int amount;
}
