package com.navisharma.SpringCRMWebAppThymeleaf.repo;

import com.navisharma.SpringCRMWebAppThymeleaf.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer,Integer>
{

}
