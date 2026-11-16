package com.example.stockManagement.entity;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Stock {
	
	private Integer stockId;
	
	
	@NotNull
	private Date recordDt;
	
	
	@NotNull
	private String stockName;
	
	
	@NotNull
	private Integer stockLevel;
}
