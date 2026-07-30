package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>
{
    //findBy-PropertyName-keyword

    public List<Vaccine> findByCost(Double cost);
//    public List<Vaccine> findByCostIs(Double cost);
//    public List<Vaccine> findByCostEquals(Double cost);

    public List<Vaccine> findByCostLessThanEqual(Double cost);

    public List<Vaccine> findByCostBetween(Double startCost,Double endingCost);

    public List<Vaccine> findByVaccineCompanyEquals(String name);

    public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost);

}
