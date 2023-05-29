package com.example.demo.service;

import com.example.demo.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {
    City getCityById(int id);

    void saveOrUpdate(City city);

    void delete(int id);

    List<City> getAllCities();

    void getAllCitiesContainsName(String name);
}
