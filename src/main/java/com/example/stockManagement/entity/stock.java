package com.example.stockManagement.entity;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class stock {
	
	private Integer stockId;
	
	
	@NotNull
	private Date record;
	
	
	@NotNull
	private String stockName;
	
	
	@NotNull
	private Integer stockLevel;
}
