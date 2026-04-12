package com.learning.telusko.service;

import com.learning.telusko.entity.Tourist;

import java.util.List;

public interface ITouristManagement {
    public String register(Tourist tourist);
    public List<Tourist> getAllTourist();
    public Tourist getTouristById(Long id);

    public String updateFullById(Tourist tourist);
    public String updateCityById(Long id, String city);

    public String deleteBYId(Long id);
}

