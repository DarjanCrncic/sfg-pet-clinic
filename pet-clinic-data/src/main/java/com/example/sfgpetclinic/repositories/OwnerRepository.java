package com.example.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
