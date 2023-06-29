package com.lk.sliit.rocart.service.impl;



import com.eCommerceProject.service.SendEmailService;

import com.lk.sliit.rocart.repository.ProductRepository;
import com.lk.sliit.rocart.request.CampaignCreateRequest;
import com.lk.sliit.rocart.service.UpdateProductPriceService;
import com.lk.sliit.rocart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductPriceServiceImpl implements UpdateProductPriceService {

    private final ProductRepository productRepository;

    private final SendEmailService emailService;

    private final UserService userService;

    @Override
    public void createCampaign(CampaignCreateRequest campaignCreateRequest) {
        Optional<Product> product = productRepository.findById(campaignCreateRequest.getProductId());
        List<User> users = userService.getAll();

        if (product.isPresent()) {
            product.get().setProductPrice( product.get().getProductPrice() - campaignCreateRequest.getDiscountAmount());
            productRepository.save(product.get());

            for (User user : users) {
                if (user.isNotificationPermission()) {
                    emailService.sendEmails(user.getEMail(), "Big Discount", product.get().getProductBrand() +" "+ product.get().getProductName()
                            + " Big discount on product!");
                }
            }
        }
    }

    @Override
    public void priceIncrease(PriceIncreaseRequest priceIncreaseRequest) {
        Optional<Product> product = productRepository.findById(priceIncreaseRequest.getProductId());

        if (product.isPresent()) {
            product.get().setProductPrice(product.get().getProductPrice() + priceIncreaseRequest.getAmount());
            productRepository.save(product.get());
        }
    }
}
