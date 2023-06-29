package com.lk.sliit.rocart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

    private String productName;
    private String productBrand;
    private String productDetails;
    private double productPrice;
    private int stock;
    private String productImageUrl;

}
