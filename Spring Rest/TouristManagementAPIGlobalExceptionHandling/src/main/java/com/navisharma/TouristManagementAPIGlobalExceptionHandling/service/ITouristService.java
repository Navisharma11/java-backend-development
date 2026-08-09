package com.navisharma.TouristManagementAPIGlobalExceptionHandling.service;

import com.navisharma.TouristManagementAPIGlobalExceptionHandling.exception.TouristNotFoundException;
import com.navisharma.TouristManagementAPIGlobalExceptionHandling.model.Tourist;

import java.util.List;

public interface ITouristService
{
    String registerTourist(Tourist tourist);
    Tourist fetchTouristById(Integer id) throws TouristNotFoundException;
    List<Tourist> fetchAllTouristInfo();
    String updateTheTouristInfo(Tourist tourist);
    String updateTheTouristBudget(Integer id,Double budget);
    String deleteTouristInfoById(Integer id);
}
