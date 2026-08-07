package com.navisharma.SpringCRMWebApp.service;


import com.navisharma.SpringCRMWebApp.model.Customer;

import java.util.List;

public interface ICustomerService
{
     public List<Customer> getCustomerInfo();
     public void registerCustomer(Customer customer);
     public Customer fetchCxById(Integer id);
     public void deleteCxRecord(Integer id);
}
