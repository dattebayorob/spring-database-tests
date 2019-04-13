package com.dtb.springdatabase.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.springdatabase.model.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	
}
