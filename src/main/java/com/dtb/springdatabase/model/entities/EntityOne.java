package com.dtb.springdatabase.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "entity_one", schema = "manytomany")
public class EntityOne {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "one", cascade = CascadeType.ALL)
	Set<OneToTwo> twos;
	
	public Set<OneToTwo> getTwos(){
		if(twos == null)
			twos = new HashSet<>();
		return twos;
	}
}
