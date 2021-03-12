package com.example.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
