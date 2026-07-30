package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import com.navisharma.view.ResultView;

import javax.xml.transform.Result;
import java.util.List;

public interface IVaccineService
{
    public List<ResultView> fetchByCost(Double cost);

}
