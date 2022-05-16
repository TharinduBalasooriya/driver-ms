package com.ms.driverService.service;

import com.ms.driverService.exception.ResourceNotFoundException;
import com.ms.driverService.model.Driver;
import com.ms.driverService.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverRepository driverRepository;
    @Override
    public Driver saveDriver(Driver driver) {
        return this.driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return this.driverRepository.findAll();
    }

    @Override
    public Driver getBtId(String id) {
        return this.driverRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Driver","id",id));
    }

    @Override
    public void deleteDriver(String id) {
        this.driverRepository.deleteById(id);
    }

    @Override
    public Driver updateDriver(String id, Driver driver) {

        Driver currDriver = this.driverRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Driver","id",id));
        currDriver.setFirstName(driver.getFirstName());
        currDriver.setLastName(driver.getLastName());
        currDriver.setContactNumbers(driver.getContactNumbers());
        currDriver.setRating(driver.getRating());

        return  this.driverRepository.save(currDriver);
    }
}
