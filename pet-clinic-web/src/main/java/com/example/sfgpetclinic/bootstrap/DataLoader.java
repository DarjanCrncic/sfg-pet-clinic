package com.example.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.SpecialityService;
import com.example.sfgpetclinic.services.VetService;
import com.example.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
			
		if(count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Dog");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("bla bla Street");
		owner1.setCity("Miami");
		owner1.setTelephone("15156167");
			
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setBirthday(LocalDate.now());
		mikesPet.setOwner(owner1);
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Axe");
		owner2.setAddress("123 izh");
		owner2.setCity("Miami");
		owner2.setTelephone("15156167");
		
		Pet fionasCat = new Pet();
		fionasCat.setPetType(savedCatPetType);
		fionasCat.setBirthday(LocalDate.now());
		fionasCat.setOwner(owner2);
		fionasCat.setName("Julia");
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("sneazy kitty");
		
		visitService.save(catVisit);
		
		Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
	}	
}
