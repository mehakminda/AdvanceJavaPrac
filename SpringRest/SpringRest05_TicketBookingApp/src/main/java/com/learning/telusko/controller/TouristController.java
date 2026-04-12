package com.learning.telusko.controller;

import com.learning.telusko.entity.Tourist;
import com.learning.telusko.exception.TouristNotFoundException;
import com.learning.telusko.service.ITouristManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    ITouristManagement service;

    @PostMapping("/addTourist")
    public ResponseEntity<String> addTourist(@RequestBody Tourist tourist){
        try {
            System.out.println("Adding tourist object: "+tourist.toString());
            String msg = service.register(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Some problem in enrolling tourist.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable Long id){
        try {
            Tourist tourist = service.getTouristById(id);
            System.out.println("Retrieving tourist object from db based on ID: "+tourist.toString());
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        }
        catch(TouristNotFoundException tn){
           return new ResponseEntity<>(tn.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTourist(){
        try{
            List<Tourist> list = service.getAllTourist();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Some problem in fetching all records", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateTourist") //entire record
    public ResponseEntity<?> updateTouristRecord(@RequestBody Tourist tourist){

        try{
            System.out.println("Record to be updated with : "+ tourist.toString());
            String msg=  service.updateFullById(tourist);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }
    @PatchMapping("/updateCity/{id}/{newCity}") //entire record
    public ResponseEntity<?> updateTouristRecord(@PathVariable Long id, @PathVariable String newCity){
        try{
            Tourist tourist = service.getTouristById(id);
            System.out.println("Record to be updated with new city for :"+tourist.toString());
            String msg= service.updateCityById(id,newCity);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }
        catch(TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/deleteByID/{id}")
    public ResponseEntity<?>  deleteByID(@PathVariable Long id){
        try{
            Tourist tourist = service.getTouristById(id);
            System.out.println("Record to be deleted with new city for :"+tourist.toString());
            String msg = service.deleteBYId(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }
        catch (TouristNotFoundException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

/**
 * Controllers shouldn't handle exception, hence global exception handlers came into the picture
 * Seperation of concerns : aop (aspect oriented programming)
 */