package com.jk.carfullstackapp.Domain;

import com.jk.carfullstackapp.Model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

	Optional<Car> findByBrand(@Param("carBrand") String brand);
	Optional<Car> findByColor(@Param("carColor") String color);

}
