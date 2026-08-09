package com.navisharma.TouristManagementAPIGlobalExceptionHandling.dao;

import com.navisharma.TouristManagementAPIGlobalExceptionHandling.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist,Integer>
{

}
