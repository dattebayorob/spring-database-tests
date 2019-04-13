package com.dtb.springdatabase.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "workplace", schema = "place")
public class Worplace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String initials;
	@Column(nullable = false)
	private String name;
	@Column(name = "id_workplace_father", nullable = false)
	private Long idWorkplaceFather;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_address", nullable = false)
	private Address address;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workplace")
	private List<People> peoples;
	
	public Worplace() {
		// TODO Auto-generated constructor stub
	}
}
