package com.navisharma.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FirstFlight implements IDelivery
{
    public FirstFlight()
    {
        System.out.println("FirstFlight Bean Created");
    }

    @Override
    public Boolean deliveryTheProduct(Double amount)
    {
        System.out.println("Product Delivered with FirstFlight and Amount paid is "+amount);
        return true;
    }
}
