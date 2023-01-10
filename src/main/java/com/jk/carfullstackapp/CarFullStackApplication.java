package com.jk.carfullstackapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jk.carfullstackapp.Domain.CarRepository;
import com.jk.carfullstackapp.Domain.OwnerRepository;
import com.jk.carfullstackapp.Model.Car;
import com.jk.carfullstackapp.Model.Owner;

@SpringBootApplication
public class CarFullStackApplication {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarFullStackApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args-> {

            Owner firstOwner = new Owner("Shaik", "Zahid");
            Owner secondOwner = new Owner("Shaik", "Mohiddin");

            ownerRepository.save(firstOwner);
            ownerRepository.save(secondOwner);


            carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, firstOwner));
            carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, secondOwner));
            carRepository.save(new Car("toyota", "prius", "silver", "kko-0212", 2018, 39000, secondOwner));
        };
    }

}
