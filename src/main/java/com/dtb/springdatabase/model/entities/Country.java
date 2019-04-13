package com.dtb.springdatabase.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "country", schema = "place")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String initials;
	@Column(nullable = false)
	private String name;
	@OneToMany(mappedBy = "country")
	private List<FederationUnity> federationUnities;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}
}
