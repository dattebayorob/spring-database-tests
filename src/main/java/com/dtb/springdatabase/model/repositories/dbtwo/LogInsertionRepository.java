package com.dtb.springdatabase.model.repositories.dbtwo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.springdatabase.model.entities.LogInsertion;

public interface LogInsertionRepository extends JpaRepository<LogInsertion, Long>{
	
}
