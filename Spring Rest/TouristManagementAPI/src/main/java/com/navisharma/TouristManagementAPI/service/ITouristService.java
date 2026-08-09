package com.navisharma.TouristManagementAPI.service;

import com.navisharma.TouristManagementAPI.exception.TouristNotFoundException;
import com.navisharma.TouristManagementAPI.model.Tourist;

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
