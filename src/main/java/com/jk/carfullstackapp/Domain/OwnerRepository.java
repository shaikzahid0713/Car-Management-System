package com.jk.carfullstackapp.Domain;

import org.springframework.data.repository.CrudRepository;

import com.jk.carfullstackapp.Model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
