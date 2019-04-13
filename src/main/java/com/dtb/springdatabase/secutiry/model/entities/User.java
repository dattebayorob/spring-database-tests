package com.dtb.springdatabase.secutiry.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dtb.springdatabase.model.entities.People;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "security")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@OneToOne(fetch = FetchType.LAZY)
	private People people;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
}
