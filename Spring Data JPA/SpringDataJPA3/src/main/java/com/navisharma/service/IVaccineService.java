package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IVaccineService
{
    public Iterable<Vaccine> fetchDetailsBySorting(boolean status,String...properties);

    public Page<Vaccine> fetchDetailsByPagenation(int pgNo, int pgSize, boolean status, String...properties);

    public void fetchDetailsByPagenation(int pgSize);
}
