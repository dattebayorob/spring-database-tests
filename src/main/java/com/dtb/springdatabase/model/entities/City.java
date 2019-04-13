package com.dtb.springdatabase.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "city", schema = "place")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_federation_unity", nullable = false)
	private FederationUnity federationUnity;
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<Address> addresses;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
}
