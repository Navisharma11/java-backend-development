package com.navisharma.repo;

import com.navisharma.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepo extends MongoRepository<Customer,String>
{

}
