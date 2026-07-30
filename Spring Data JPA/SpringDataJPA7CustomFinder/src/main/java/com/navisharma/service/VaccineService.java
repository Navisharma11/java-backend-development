package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import com.navisharma.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class VaccineService implements IVaccineService
{
    private IVaccineRepo repo;

    @Autowired
    public void setRepo(IVaccineRepo repo)
    {
        this.repo = repo;
    }


    @Override
    public List<Vaccine> fetchByCost(Double cost) {
        return repo.findByCost(cost);
    }

    @Override
    public List<Vaccine> fetchByCostLessThanEqual(Double cost) {
        return repo.findByCostLessThanEqual(cost);
    }

    @Override
    public List<Vaccine> fetxhByCostBetween(Double startCost, Double endingCost) {
        return repo.findByCostBetween(startCost, endingCost);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompanyEquals(String name) {
        return repo.findByVaccineCompanyEquals(name);
    }

    @Override
    public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost) {
        return repo.findByVaccineNameInAndCostBetween(names, minCost, maxCost);
    }
}

