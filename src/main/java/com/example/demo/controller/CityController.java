package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

   /* @GetMapping("/")
    public String getStudents(@RequestParam String name){
        return "hi "+name;
    }
    @GetMapping("/{id}/")
    public String getStudent(@PathParam("id") int id){
        return "hi "+id;
    }*/

    //autowire the cityService class
    @Autowired
    CityService cityService;
    //creating a get mapping that retrieves all the cities detail from the database
    @GetMapping("/city")
    private ResponseEntity<List<City>> getAllCities(@RequestParam(required = false) String name)
    {
        try {
            List<City> tutorials = new ArrayList<City>();

            if (name == null)
                cityService.getAllCities();
            else
                cityService.getAllCitiesContainsName(name);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       // return cityService.getAllCities();
    }
    //creating a get mapping that retrieves the detail of a specific city
    @GetMapping("/city/{id}")
    private City getBooks(@PathVariable("bookid") int id)
    {
        return cityService.getCityById(id);
    }
    //creating a delete mapping that deletes a specified city
    @DeleteMapping("/city/{id}")
    private ResponseEntity<Object> deleteCity(@PathVariable("id") int id)
    {
        //cityService.delete(id);
        try {
            cityService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //creating post mapping that post the city detail in the database
    @PostMapping("/city")
    private int saveCity(@RequestBody City city)
    {
        cityService.saveOrUpdate(city);
        return city.getID();
    }
    //creating put mapping that updates the city detail
    @PutMapping("/books")
    private City update(@RequestBody City city)
    {
        cityService.saveOrUpdate(city);
        return city;
    }
}
