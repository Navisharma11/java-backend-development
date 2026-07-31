package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import com.navisharma.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
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
    public List<Vaccine> fetchByVaccineCompany(String companyName) {
        return repo.searchByVaccineCompany(companyName);
    }

    @Override
    public List<Vaccine> fetchByVaccineCompany(String comp1, String comp2) {
        return repo.searchByVaccineCompany(comp1, comp2);
    }

    @Override
    public List<Object[]> fetchByVaccineCost(Double startingRange, Double maxRange) {
        return repo.searchByVaccineCost(startingRange, maxRange);
    }

    @Override
    public int updateThePriceByVaccineName(Double newPrice, String vaccineName) {
        return repo.updatePriceByVaccineName(newPrice, vaccineName);
    }

    @Override
    public int deleteTheVaccinesByVaccineNames(String vaccineName) {
        return repo.deleteVaccinesByVaccineNames(vaccineName);
    }

    @Override
    public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Double cost) {
        return repo.insertVaccineInfo(id, vaccineName, vaccineCompany, cost);
    }

    @Override
    public LocalDateTime getSystemDateAndTime() {
        return repo.getTheSystemDateAndTime();
    }
}

