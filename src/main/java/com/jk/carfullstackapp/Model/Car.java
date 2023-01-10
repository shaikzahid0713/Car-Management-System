package com.jk.carfullstackapp.Model;

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
    @Column(name = "ID")
    private Long carId;

    @Column(name = "Brand")
    private String carBrand;

    @Column(name = "Model")
    private String  carModel;

    @Column(name = "Color")
    private String  carColor;

    @Column(name = "Registration_Number")
    private String  carRegistrationNumber;

    @Column(name = "Year_Of_Purchase")
    private Integer carYearOfPurchase;

    @Column(name = "Price")
    private Integer  carPrice;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car (String carBrand, String carModel, String carColor, String carRegistrationNumber,
                Integer carYearOfPurchase, Integer carPrice, Owner owner) {

        super();
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carRegistrationNumber = carRegistrationNumber;
        this.carYearOfPurchase = carYearOfPurchase;
        this.carPrice = carPrice;
        this.owner = owner;
    }

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
	