package com.boukezzoula.expensesmanager.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_expenses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(unique = true)
	private String expenseId;
	
	private String expenseName;
	
	private String exepnseDesc;
	
	private BigDecimal expenseAmount;
	
	private Date date;
	
}
