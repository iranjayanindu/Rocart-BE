package com.lk.sliit.rocart.service;


import com.lk.sliit.rocart.request.CampaignCreateRequest;
import com.lk.sliit.rocart.request.PriceIncreaseRequest;

public interface UpdateProductPriceService {
    void createCampaign(CampaignCreateRequest campaignCreateRequest);
    void priceIncrease(PriceIncreaseRequest priceIncreaseRequest);
}
