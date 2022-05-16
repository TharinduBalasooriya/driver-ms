package com.ms.driverService.controller;

import com.ms.driverService.domain.Message;
import com.ms.driverService.exception.ResourceNotFoundException;
import com.ms.driverService.model.Driver;
import com.ms.driverService.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;
    @GetMapping("/")
    public String homeAPI(){

        return "Driver API v1";
    }

    @PostMapping("/api/driver")
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver){

        return new ResponseEntity<Driver>(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping("/api/driver/{id}")
    public ResponseEntity<Driver> getById(@PathVariable("id") String driverId){

        return new ResponseEntity<Driver>(driverService.getBtId(driverId),HttpStatus.OK);
    }

    //Get All Drivers
    @GetMapping("/api/driver")
    public  ResponseEntity<List<Driver>> getAllDrivers(){
        return new ResponseEntity<List<Driver>>(driverService.getAllDrivers(),HttpStatus.OK);
    }

    //Delete driver by id
    @DeleteMapping("/api/driver/{id}")
    public ResponseEntity<Message> deleteDriver(@PathVariable("id") String id){
        try{
            driverService.deleteDriver(id);
            Message message =  new Message("Driver " + id+ "deleted Successfully");
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (ResourceNotFoundException ex){
            Message message =  new Message("Driver " + id+ "deleted failed,No driver available");
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
    }

    //Update Driver

    @PutMapping("/api/driver/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") String id,@RequestBody Driver driver){
        return  new ResponseEntity<>(this.driverService.updateDriver(id,driver),HttpStatus.OK);
    }
}
