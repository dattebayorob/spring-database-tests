package com.dtb.springdatabase.model.entities.acossiative;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dtb.springdatabase.model.entities.EntityOne;
import com.dtb.springdatabase.model.entities.EntityTwo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"one", "two"})
@Entity
@Table(name = "one_two", schema = "manytomany")
public class OneToTwo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "one_id")
	private EntityOne one;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "one_two")
	private EntityTwo two;
}
