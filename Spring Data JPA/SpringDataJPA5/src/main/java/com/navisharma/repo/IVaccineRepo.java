package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import com.navisharma.view.ResultView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>
{
    //findBy-propertyName-keyword
    List<ResultView> findByCostLessThan(Double cost);

}
