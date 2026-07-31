package com.navisharma.repo;

import com.navisharma.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>
{
//    @Query("From Vaccine WHERE vaccineCompany=:company")
//    public List<Vaccine> searchByVaccineCompany(String company);


    @Query("From Vaccine WHERE vaccineCompany=:company")
    public List<Vaccine> searchByVaccineCompany(@Param("company") String companyName);

    @Query("From Vaccine WHERE vaccineCompany IN(:comp1,:comp2)")
    public List<Vaccine> searchByVaccineCompany(String comp1, String comp2);


    @Query("Select vaccineName,vaccineCompany From Vaccine WHERE cost BETWEEN :startingRange AND :maxRange")
    public List<Object[]> searchByVaccineCost(Double startingRange, Double maxRange);

    @Transactional
    @Modifying
    @Query("UPDATE Vaccine SET cost =:newPrice Where vaccineName=:vaccineName")
    public int updatePriceByVaccineName(Double newPrice, String vaccineName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vaccine WHERE vaccineName =:vaccineName")
    public int deleteVaccinesByVaccineNames(String vaccineName);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO vaccine(id,vaccine_name,vaccine_company,cost)VALUES(?,?,?,?) ",nativeQuery = true)
    public int insertVaccineInfo(Integer id,String vaccineName, String vaccineCompany, Double cost);

    @Query(value ="SELECT NOW()",nativeQuery = true)
    public LocalDateTime getTheSystemDateAndTime();

}
