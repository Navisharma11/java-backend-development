package com.navisharma.service;

import com.navisharma.entity.Vaccine;
import com.navisharma.repo.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Iterable<Vaccine> fetchDetailsBySorting(boolean status, String...properties) {
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC,properties );
        return repo.findAll(sort);
    }

    @Override
    public Page<Vaccine> fetchDetailsByPagenation(int pgNo, int pgSize, boolean status, String... properties) {
//        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC,properties);
        PageRequest pageable = PageRequest.of(pgNo, pgSize, status ? Sort.Direction.ASC : Sort.Direction.DESC,properties);
        Page<Vaccine> page = repo.findAll(pageable);
        return page;
    }

    @Override
    public void fetchDetailsByPagenation(int pgSize)
    {
        long count = 7l;

        long pageCount = count/pgSize;   //4/2==>2     12/3==>4
        //14.5==>2.8 ==>3

        pageCount=count%pgSize==0?pageCount:++pageCount;

        for(int i=0;i<pageCount;i++)
        {
            PageRequest pageable = PageRequest.of(i, pgSize);
            Page<Vaccine> page = repo.findAll(pageable);
            page.getContent().forEach(v -> System.out.println(v.getVaccineName() + " " + v.getVaccineCompany()));
            System.out.println("------------------------------------------------------------------------------");
        }

    }
}
