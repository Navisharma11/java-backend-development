package com.navisharma.SpringCRMWebAppThymeleaf.service;

import com.navisharma.SpringCRMWebAppThymeleaf.model.Customer;

import java.util.List;

public interface ICustomerService
{
    public List<Customer> getCustomerInfo();
    public void registerCustomer(Customer customer);
    public Customer fetchCxById(Integer id);
    public void deleteCxRecord(Integer id);
}
