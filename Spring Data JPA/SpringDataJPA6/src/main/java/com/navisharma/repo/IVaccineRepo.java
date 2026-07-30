package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import com.navisharma.view.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>
{
    //findBy-propertyName-keyword
    public<T extends View> List<T> findByCostLessThan(Double cost, Class<T> cls);

}
