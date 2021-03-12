package com.example.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
