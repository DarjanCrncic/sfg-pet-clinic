package com.example.sfgpetclinic.services;

import java.util.Set;

import com.example.sfgpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
