package com.example.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
