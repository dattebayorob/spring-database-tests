package com.dtb.springdatabase.model.repositories.dbone.custom;

import java.util.List;
import java.util.Map;

import com.dtb.springdatabase.model.entities.People;

public interface PeopleRepositoryQuery {
	List<People> findByFilters(Map<String,String> filters);
}
