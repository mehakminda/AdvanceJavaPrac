package com.learning.telusko.service;

import com.learning.telusko.dao.ITouristRepository;
import com.learning.telusko.entity.Tourist;
import com.learning.telusko.exception.TouristNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristManagement implements ITouristManagement{

    @Autowired
    ITouristRepository repo;

    @Override
    public String register(Tourist tourist) {
        Long id = repo.save(tourist).getTId();
        return "Saved tourist with id:" + id;
    }

    @Override
    public List<Tourist> getAllTourist() {
       return repo.findAll();
    }

    @Override
    public Tourist getTouristById(Long id) {

 //       Optional optional=repo.findById(id);
//		Object tourist = optional.get();
//		return tourist;
        return repo.findById(id).
                orElseThrow(()->new TouristNotFoundException("Tourist with id "+ id+" Not found"));


    }

    @Override
    public String updateFull(Tourist tourist) {
        // if present it will update or else will create new record
        Long id= tourist.getTId();
        Optional optional = repo.findById(id);
        if(optional.isPresent()){
            repo.save(tourist);
            return "Tourist with id "+ tourist.getTId()+" is updated";
        }
        else{
             throw new TouristNotFoundException( "Tourist with id "+ tourist.getTId() +" is not found");
        }
    }

    @Override
    public String updateCityById(Long id, String newCity) {
        Optional optional = repo.findById(id);
        if(optional.isPresent()){
            Tourist tourist = (Tourist) optional.get(); //gives tourist object
            tourist.setCity(newCity); //changing in object
            repo.save(tourist); //changing in db
            return "Tourist with id "+ id + " is updated";
        }
        else{
            throw new TouristNotFoundException("Tourist with id "+ id +" is not found");
        }
    }


    @Override
    public String deleteBYId(Long id) {
        Optional optional = repo.findById(id);
        if(optional.isPresent()){
            Tourist tourist = (Tourist) optional.get();
            repo.delete(tourist);
            return "Tourist with id "+id + " is deleted";
        }
        else{
            throw new TouristNotFoundException("Tourist with id "+ id +" is not found");
        }

    }
}
