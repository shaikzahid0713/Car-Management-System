package com.jk.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OwnerId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Car> cars;

    public Owner (String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals (Object o) {

        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass(this) != Hibernate.getClass(o) ) return false;
        Owner owner = (Owner) o;
        return OwnerId != null && Objects.equals(OwnerId, owner.OwnerId);
    }

    @Override
    public int hashCode () {

        return getClass().hashCode();
    }

}
