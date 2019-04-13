package com.dtb.springdatabase.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "federation_unity", schema = "place")
public class FederationUnity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String initials;
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_country")
	private Country country;
	@OneToMany(mappedBy = "federationUnity")
	private List<City> cities;
	
	public FederationUnity() {
		// TODO Auto-generated constructor stub
	}
}
