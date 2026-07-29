package com.navisharma.service;

import com.navisharma.entity.Vaccine;

import java.util.List;

public interface IVaccineService
{

    public Vaccine searchVaccineById(Integer id);

    public List<Vaccine> searchVaccineByGivenInfo(Vaccine vaccine);

    public String removeVaccineInfoByIds(Iterable<Integer> ids);

}
