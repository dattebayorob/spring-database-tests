package com.dtb.springdatabase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

public interface OneToTwoRepository extends CrudRepository<OneToTwo, Integer>{
	public void deleteByOneIdAndTwoIdNotIn(Integer oneId, List<Integer> twoIds);
	public void deleteByTwoIdAndOneIdNotIn(Integer twoId, List<Integer> OneIds);
}
