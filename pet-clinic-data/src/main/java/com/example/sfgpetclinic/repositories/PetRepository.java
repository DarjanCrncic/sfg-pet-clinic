package com.example.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
