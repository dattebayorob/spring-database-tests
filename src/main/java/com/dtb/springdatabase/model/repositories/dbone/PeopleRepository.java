package com.dtb.springdatabase.model.repositories.dbone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.springdatabase.model.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	List<People> findByAddressCityNameContaining(String cityName);
}
