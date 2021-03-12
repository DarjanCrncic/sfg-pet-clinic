package com.example.sfgpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.repositories.SpecialtyRepository;
import com.example.sfgpetclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialityService{
	
	SpecialtyRepository specialtyRepository;
	
	public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialtyRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}

}
