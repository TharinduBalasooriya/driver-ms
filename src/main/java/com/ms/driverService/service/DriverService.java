package com.ms.driverService.service;

import com.ms.driverService.model.Driver;

import java.util.List;

public interface DriverService {

    /**
     * Create Driver
     * Get All Drivers
     * Get Driver by Id
     * Delete Driver by Id
     * Update Driver
     */

    Driver saveDriver(Driver driver);
    List<Driver> getAllDrivers();
    Driver getBtId(String id);
    void deleteDriver(String id);
    Driver updateDriver(String Id,Driver driver);

}
