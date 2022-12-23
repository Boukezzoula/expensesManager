package com.boukezzoula.expensesmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boukezzoula.expensesmanager.dto.ExpenseDto;
import com.boukezzoula.expensesmanager.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExpenseConroller {
 
	private final ExpenseService expService;
	
	@GetMapping("/expenses")
	public String showExpenseList(Model model) {
		List<ExpenseDto> expenses = expService.getAllExpenses();
		model.addAttribute("expenses", expenses);
		return "expenses-list";
	}
	
	@GetMapping("/add-expense")
	public String addNewExpense() {
		
		return "add-expense";
	}
	
	@PostMapping("/add-expense")
	public String saveNewExpense() {
		
		return "add-expense";
	}
}
