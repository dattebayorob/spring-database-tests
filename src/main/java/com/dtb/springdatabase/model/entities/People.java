package com.dtb.springdatabase.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "people", schema = "people")
public class People {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_workplace", nullable = false)
	private Worplace workplace;
	@OneToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name = "id_address")
	private Address address;
	
	public People() {
		// TODO Auto-generated constructor stub
	}
}
