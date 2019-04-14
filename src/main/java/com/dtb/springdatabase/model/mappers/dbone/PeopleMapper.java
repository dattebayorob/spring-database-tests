package com.dtb.springdatabase.model.mappers.dbone;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dtb.springdatabase.model.vos.PeopleVO;

public interface PeopleMapper {
	List<PeopleVO> findByAdressCityName(@Param("CITY_NAME") String cityName);
}
