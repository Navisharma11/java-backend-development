package com.navisharma.SpringCRMWebApp.repo;

import com.navisharma.SpringCRMWebApp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Customer,Integer>
{

}
