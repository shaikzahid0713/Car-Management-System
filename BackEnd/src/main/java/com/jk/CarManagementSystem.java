package com.jk;

import com.jk.Model.Car;
import com.jk.Model.Owner;
import com.jk.Model.User;
import com.jk.Repository.CarRepository;
import com.jk.Repository.OwnerRepository;
import com.jk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarManagementSystem {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main (String[] args) {

        SpringApplication.run(CarManagementSystem .class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return  args -> {

            Owner firstOwner = new Owner("Shaik", "Zahid");
            ownerRepository.save(firstOwner);

            Owner secondOwner = new Owner("Shaik", "Mohiddin");
            ownerRepository.save(secondOwner);

            Car firstCar = new Car("Ford", "Red", "2014", "AEF-1010", 140000L, firstOwner);
            carRepository.save(firstCar);

            Car secondCar = new Car("Bugatti", "Black", "2019", "AEF-1980", 270000L, secondOwner);
            carRepository.save(secondCar);

            User firstUser = new User("user", "0713", "USER");
            userRepository.save(firstUser);

            User secondUser = new User("admin", "0713", "ADMIN");
            userRepository.save(secondUser);
        };
    }

}
