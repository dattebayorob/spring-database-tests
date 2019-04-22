package com.dtb.springdatabase.model.repositories.dbone;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dtb.springdatabase.model.entities.People;
import com.dtb.springdatabase.model.repositories.dbone.custom.PeopleRepositoryQuery;

public interface PeopleRepository extends JpaRepository<People, Long>, PeopleRepositoryQuery{
	List<People> findByAddressCityNameContaining(String cityName);
	Page<People> findByNameContainingAndWorkplaceAddressCityFederationUnityInitials(String name, String fu, Pageable pageable);
	@Query(name = "findByNameAndFUInitials",
		value = "select p from People p"
				+ " where lower(p.name) like '%'||(:name)||'%' and p.workplace.address.city.federationUnity.initials = (:fu)")
	List<People> findByNameAndFUInitials(@Param("name") String name, @Param("fu") String fu);
	@Query(name = "findByIdFetch",
		value ="select p from People p join fetch p.address join fetch p.workplace w join fetch w.address a join fetch a.city c join fetch c.federationUnity fu where p.id = :id")
	People findByIdFetch(@Param("id") Long id);
}
