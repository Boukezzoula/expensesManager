package com.boukezzoula.expensesmanager.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

	
	private long Id;
	private String expenseId;
	
	private String expenseName;
	
	private String exepnseDesc;
	
	private BigDecimal expenseAmount;
	
	private Date date;
	
	private String dateString;
}
