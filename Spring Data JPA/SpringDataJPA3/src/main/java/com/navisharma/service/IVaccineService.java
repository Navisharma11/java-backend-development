package com.navisharma.service;

import com.navisharma.entity.Vaccine;

import java.util.List;
import java.util.Optional;

public interface IVaccineService
{
    public String registerVaccineInfo(Vaccine vacine);

    public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccines);

    public Long vaccinescount();

    public Boolean checkVaccineAvailability(Integer id);

    public Iterable<Vaccine> getAllVaccineInfo();

    public Iterable<Vaccine> getAllVaccines(Iterable<Integer> ids);

    public Optional<Vaccine> getVaccineById(Integer id);

    public String removeVaccineById(Integer id);

    public String removeVaccineByVaccine(Vaccine obj);

    public String removeAllVaccinesByIds(List<Integer> ids);


}
