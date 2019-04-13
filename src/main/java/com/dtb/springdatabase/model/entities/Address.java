package com.dtb.springdatabase.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "place")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String address;
	private String number;
	@ManyToOne
	@JoinColumn(name = "id_city", nullable = false)
	private City city;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
}
