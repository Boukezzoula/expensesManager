package com.boukezzoula.expensesmanager.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.boukezzoula.expensesmanager.dto.ExpenseDto;
import com.boukezzoula.expensesmanager.entity.Expense;
import com.boukezzoula.expensesmanager.repository.ExpenseRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
 
	private final ExpenseRepo expenseRepo ;
	
	private final ModelMapper modelMapper;
	
	public List<ExpenseDto> getAllExpenses(){
		List<Expense> list = expenseRepo.findAll();
		List<ExpenseDto> expenseList =list.stream().map(this:: mapToDto).collect(Collectors.toList());
		return expenseList;
	
	}
	
	private ExpenseDto mapToDto(Expense exp) {
		ExpenseDto expenseDto = modelMapper.map(exp, ExpenseDto.class);
		return expenseDto;
		
	}
	
	public ExpenseDto saveExpense(ExpenseDto expenseDto) {
	Expense expense =	mapToEntity(expenseDto);
	
	expense = expenseRepo.save(expense);
	
	return mapToDto(expense);
	
	}

	private Expense mapToEntity(ExpenseDto expenseDto) {
		Expense expense = modelMapper.map(expenseDto, Expense.class);
		
		expense.setExpenseId(UUID.randomUUID().toString());
		
		return expense;
	}
}
