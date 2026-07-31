package com.navisharma.service;

import com.navisharma.dto.CustomerDTO;
import com.navisharma.model.Customer;

import java.util.List;

public interface ICustomerService
{
    public String registerCustomer(CustomerDTO dto);
    public List<Customer> findAllCustomer();
    public String removeDocument(String id);
}
