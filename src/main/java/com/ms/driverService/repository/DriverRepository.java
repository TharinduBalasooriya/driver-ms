package com.ms.driverService.repository;

import com.ms.driverService.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver,String> {

}
