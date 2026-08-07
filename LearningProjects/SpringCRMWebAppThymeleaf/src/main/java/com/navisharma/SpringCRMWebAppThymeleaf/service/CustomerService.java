package com.navisharma.SpringCRMWebAppThymeleaf.service;

import com.navisharma.SpringCRMWebAppThymeleaf.model.Customer;
import com.navisharma.SpringCRMWebAppThymeleaf.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService
{
    private ICustomerRepo repo;

    @Autowired
    public void setRepo(ICustomerRepo repo)
    {
        this.repo=repo;
    }

    @Override
    public List<Customer> getCustomerInfo()
    {
        return (List<Customer>) repo.findAll();
    }

    @Override
    public void registerCustomer(Customer customer)
    {
        repo.save(customer);
    }

    @Override
    public Customer fetchCxById(Integer id) {
        Optional<Customer> optional = repo.findById(id);
        return optional.get();
    }

    @Override
    public void deleteCxRecord(Integer id) {
        repo.deleteById(id);
    }
}
