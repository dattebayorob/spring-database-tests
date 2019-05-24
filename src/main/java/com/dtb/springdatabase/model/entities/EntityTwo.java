package com.dtb.springdatabase.model.entities;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "entity_two", schema = "manytomany")
public class EntityTwo {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "two")
	private Set<OneToTwo> ones;
	
	public Set<OneToTwo> getOnes(){
		if(ones == null)
			ones = new HashSet<>();
		return ones;
	}
}
