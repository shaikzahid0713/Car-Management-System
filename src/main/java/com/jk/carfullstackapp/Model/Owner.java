package com.jk.carfullstackapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ownerId;
	@Column(name = "First_Name")
	private String ownerFirstName;

	@Column(name = "Last_Name")
	private String  ownerLastName;


	public Owner(String ownerFirstName, String ownerLastName) {
		super();
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	@JsonIgnore
	@ToString.Exclude
	private List<Car> cars;

	@Override
	public boolean equals (Object o) {

		if ( this == o ) return true;
		if ( o == null || Hibernate.getClass(this) != Hibernate.getClass(o) ) return false;
		Owner owner = (Owner) o;
		return ownerId != null && Objects.equals(ownerId, owner.ownerId);
	}

	@Override
	public int hashCode () {

		return getClass().hashCode();
	}

}
