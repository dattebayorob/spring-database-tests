package com.dtb.springdatabase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.springdatabase.model.entities.EntityOne;
import com.dtb.springdatabase.model.entities.EntityTwo;
import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;
import com.dtb.springdatabase.repository.EntityOneRepository;
import com.dtb.springdatabase.repository.OneToTwoRepository;

@Service
public class EntityOneService {
	@Autowired
	private EntityOneRepository repository;
	@Autowired
	private OneToTwoRepository associative;
	
	public EntityOne save(String name, List<Integer> twoIds) {
		EntityOne one = EntityOne.builder().name(name).build();
		repository.save(one);
				
		one.getTwos().addAll(associatives(twoIds, one));
		
		return repository.save(one);
	}
	
	public EntityOne update(EntityOne one, List<Integer> twoIds) {
		EntityOne persisted = repository.findById(one.getId()).orElseThrow(() -> new RuntimeException("fuck it"));
		
		persisted.setName(one.getName());
		
		persisted.getTwos().addAll(associatives(twoIds, persisted));
		
		repository.save(persisted);
		
		associative.deleteByOneIdAndTwoIdNotIn(persisted.getId(), twoIds);
		
		return persisted;
		
	}
	
	private List<OneToTwo> associatives(List<Integer> twoIds, EntityOne one) {
		return 
				twoIds
				.stream()
				.map(twoId -> 
				OneToTwo.builder()
					.one(one)
					.two(EntityTwo
							.builder()
							.id(twoId)
							.build())
					.build())
				.collect(Collectors.toList());
	}
}
