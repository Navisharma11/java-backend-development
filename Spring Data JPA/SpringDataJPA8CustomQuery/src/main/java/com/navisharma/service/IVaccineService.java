package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IVaccineService
{
    public List<Vaccine> fetchByVaccineCompany(String companyName);

    public List<Vaccine> fetchByVaccineCompany(String comp1, String comp2);

    public List<Object[]> fetchByVaccineCost(Double startingRange, Double maxRange);

    public int updateThePriceByVaccineName(Double newPrice, String vaccineName);

    public int deleteTheVaccinesByVaccineNames(String vaccineName);

    public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Double cost);

    public LocalDateTime getSystemDateAndTime();
}
