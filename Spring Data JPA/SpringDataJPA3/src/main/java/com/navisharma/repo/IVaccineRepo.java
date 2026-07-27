package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface IVaccineRepo extends CrudRepository<Vaccine,Integer>
{

}
