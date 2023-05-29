package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class CityServiceImpl implements CityService{
 
        @Autowired
        CityRepository cityRepository;
        //getting all city record by using the method findaAll() of CrudRepository  
        public List<City> getAllCities()
        {
            List<City> city = new ArrayList<City>();
            cityRepository.findAll().forEach(city1 -> city.add(city1));
            return city;
        }

    @Override
    public void getAllCitiesContainsName(String name) {
        List<City> city = new ArrayList<City>();
        cityRepository.findByNameContaining(name).forEach(city::add);
    }

    //getting a specific record by using the method findById() of CrudRepository
        public City getCityById(int id)
        {
            return cityRepository.findById((long) id).get();
        }
        //saving a specific record by using the method save() of CrudRepository  
        public void saveOrUpdate(City city)
        {
            cityRepository.save(city);
        }

        //deleting a specific record by using the method deleteById() of CrudRepository  
        public void delete(int id)
        {
            cityRepository.deleteById((long) id);
        }
        //updating a record  
        public void update(City city, int id)
        {
            cityRepository.save(city);
        }
    }

