package com.boukezzoula.expensesmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boukezzoula.expensesmanager.dto.ExpenseDto;
import com.boukezzoula.expensesmanager.entity.Expense;
import com.boukezzoula.expensesmanager.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExpenseConroller {
 
	private final ExpenseService expService;
	
	@GetMapping("")
	public String showIndex(Model model) {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String showExpenseList(Model model) {
		List<ExpenseDto> expenses = expService.getAllExpenses();
		model.addAttribute("expenses", expenses);
		return "expenses-list";
	}
	
	@GetMapping("/add-expense")
	public String addNewExpense(Model model) {
		model.addAttribute("expense", new ExpenseDto());
		return "add-expense";
	}
	
	@PostMapping("/save-expense")
	public String saveExpense(@ModelAttribute("expense") ExpenseDto expenseDto) {
		System.out.println("expense details :"+expenseDto);
		expService.saveExpense(expenseDto);
		return "redirect:/expenses";
	}
}
