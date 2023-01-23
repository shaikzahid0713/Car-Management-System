package com.jk.Repository;

import com.jk.Model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByCarColor(String color);
    List<Car> findByCarBrand(String brand);
    List<Car> findByCarYearOfPurchaseOrCarRegistrationNumber(String year, Long registration_number);
}
