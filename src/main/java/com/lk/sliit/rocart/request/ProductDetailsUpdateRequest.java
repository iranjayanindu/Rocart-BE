package com.lk.sliit.rocart.request;

import lombok.Data;

@Data
public class ProductDetailsUpdateRequest {

    private int productId;

    private String productDetails;
}
