package com.example.sfgpetclinic.services;

import java.util.List;

import com.example.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
	
}
