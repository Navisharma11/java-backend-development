package com.navisharma.service;

import com.navisharma.dto.CustomerDTO;
import com.navisharma.model.Customer;
import com.navisharma.repo.ICustomerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService
{
    @Autowired
    ICustomerRepo repo;

    @Override
    public String registerCustomer(CustomerDTO dto) {
        Customer cx = new Customer();
        BeanUtils.copyProperties(dto,cx);
        Customer cxDoc = repo.save(cx);
        return "Customer Info Stored with id "+ cxDoc.getId();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return repo.findAll();
    }

    @Override
    public String removeDocument(String id) {
        Optional<Customer> optional = repo.findById(id);
        if(optional.isPresent())
        {
          repo.deleteById(id);
          return "Customer Doc with id "+ id + "id deleted";
        }
        return "No Document found with id "+ id + " to delete";
    }
}
