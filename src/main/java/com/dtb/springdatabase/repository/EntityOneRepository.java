package com.dtb.springdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.springdatabase.model.entities.EntityOne;

public interface EntityOneRepository extends JpaRepository<EntityOne, Integer>{

}
