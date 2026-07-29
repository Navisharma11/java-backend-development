package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>
{



}
