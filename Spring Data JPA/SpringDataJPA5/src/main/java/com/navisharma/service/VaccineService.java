package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import com.navisharma.repo.IVaccineRepo;
import com.navisharma.view.ResultView;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public List<ResultView> fetchByCost(Double cost) {
        return repo.findByCostLessThan(cost);
    }
}

