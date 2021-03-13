package com.example.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.SpecialityService;
import com.example.sfgpetclinic.services.VetService;

@Service
@Profile("default")
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService{
	
	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality->{
				if(speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public  void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
	
	

}
