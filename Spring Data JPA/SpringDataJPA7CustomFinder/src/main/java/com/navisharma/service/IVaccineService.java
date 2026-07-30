package com.navisharma.service;

import com.navisharma.entity.Vaccine;

import java.util.Collection;
import java.util.List;

public interface IVaccineService
{
    public List<Vaccine> fetchByCost(Double cost);
    public List<Vaccine> fetchByCostLessThanEqual(Double cost);

    public List<Vaccine> fetxhByCostBetween(Double startCost,Double endingCost);

    public List<Vaccine> fetchByVaccineCompanyEquals(String name);

    public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost);

}
