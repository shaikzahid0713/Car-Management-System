package com.jk.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long carId;
    @Column(name = "brand")
    private String carBrand;
    @Column(name = "color")
    private String carColor;

    @Column(name = "year_of_purchase")
    private String carYearOfPurchase;

    @Column(name = "registration_number")
    private String carRegistrationNumber;

    @Column(name = "price")
    private Long carPrice;

    public Car (String carBrand, String carColor, String carYearOfPurchase, String carRegistrationNumber, Long carPrice, Owner owner) {

        this.carBrand = carBrand;
        this.carColor = carColor;
        this.carYearOfPurchase = carYearOfPurchase;
        this.carRegistrationNumber = carRegistrationNumber;
        this.carPrice = carPrice;
        this.owner = owner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    @Override
    public boolean equals (Object o) {

        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass(this) != Hibernate.getClass(o) ) return false;
        Car car = (Car) o;
        return carId != null && Objects.equals(carId, car.carId);
    }

    @Override
    public int hashCode () {

        return getClass().hashCode();
    }

}
