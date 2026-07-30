package com.navisharma.service;

import com.navisharma.view.View;

import java.util.List;

public interface IVaccineService
{
    public<T extends View> List<T> fetchByCostLessThan(Double cost, Class<T> cls);

}
