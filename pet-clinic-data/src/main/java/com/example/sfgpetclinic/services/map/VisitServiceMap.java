package com.example.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.services.VisitService;

@Service
public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService{

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if(visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null)
			throw new RuntimeException("Invalid visit");
		
		return super.save(visit);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	
}
