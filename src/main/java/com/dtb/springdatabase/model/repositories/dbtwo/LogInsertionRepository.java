package com.dtb.springdatabase.model.repositories.dbtwo;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.springdatabase.model.entities.LogInsertion;

//@PersistenceContext(unitName = "dbTwo", name = "entityManagerFactoryTwo")
public interface LogInsertionRepository extends JpaRepository<LogInsertion, Long>{
	
}
