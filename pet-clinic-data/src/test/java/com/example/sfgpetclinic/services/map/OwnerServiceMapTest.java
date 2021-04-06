package com.example.sfgpetclinic.services.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServiceMap;
	
	final long ownerID = 1L;
	final String lastName = "Smith";

	@BeforeEach
	void setUp() throws Exception {
		
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		
		ownerServiceMap.save(Owner.builder().id(ownerID).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(ownerID, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerID);
		assertEquals(ownerID, owner.getId());
	}

	@Test
	void testSaveOwnerExistingID() {
		Long id = 2L;
		Owner owner2 = ownerServiceMap.save(Owner.builder().id(id).build());
		Owner savedOwner = ownerServiceMap.save(owner2);
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerNoID() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerID);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerID));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith  =ownerServiceMap.findByLastName(lastName);
		assertEquals(ownerID, smith.getId());
	}
	
	@Test
	void testFindByLastNameNotFound() {
		Owner smith  =ownerServiceMap.findByLastName("foo");
		assertNull(smith);
	}

}
