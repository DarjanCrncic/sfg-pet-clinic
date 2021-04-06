package com.example.sfgpetclinic.springdatajpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.repositories.OwnerRepository;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.repositories.PetTypeRepository;


public class OwnerSDJpaServiceTest {
	
	private static final String LAST_NAME = "Smith";

	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;

	Owner returnOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
		ownerRepository.save(returnOwner);
	}

	@Test
	void testFindAll() {
	}

	@Test
	void testFindById() {
		
		Mockito.when(ownerRepository.findById(org.mockito.ArgumentMatchers.anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(1L);
		
		assertNotNull(owner);
	}

	@Test
	void testSave() {

	}

	@Test
	void testDelete() {

	}

	@Test
	void testDeleteById() {

	}

	@Test
	void testFindByLastName() {
			
		when(ownerRepository.findByLastName(org.mockito.ArgumentMatchers.any())).thenReturn(returnOwner);
		
		Owner smith = service.findByLastName(LAST_NAME);
		
		assertEquals(LAST_NAME, smith.getLastName());
		
		verify(ownerRepository).findByLastName(org.mockito.ArgumentMatchers.any());
	}

}
