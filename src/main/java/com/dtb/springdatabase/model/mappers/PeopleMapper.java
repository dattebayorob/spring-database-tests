package com.dtb.springdatabase.model.mappers;

import java.util.List;

import com.dtb.springdatabase.model.vos.PeopleVO;

public interface PeopleMapper {
	List<PeopleVO> findAll();
}
