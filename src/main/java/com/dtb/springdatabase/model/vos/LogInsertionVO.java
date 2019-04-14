package com.dtb.springdatabase.model.vos;

import java.util.Date;

import lombok.Data;

@Data
public class LogInsertionVO {
	private Long id;
	private String description;
	private Date date;
}
