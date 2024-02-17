package com.TravelPlanningSystem.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Expense;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.ExpenseService;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("expense")
public class ExpenseController 
{
	@Autowired
	ExpenseService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Expense>> saveExpense(@RequestBody Expense exp){
		return service.saveExpense(exp);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Expense>> findExpense(@RequestParam int expenseId){
		return service.findExpense(expenseId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Expense>> deleteExpense(@RequestParam int expenseId){
		return service.deleteExpense(expenseId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Expense>> updateExpense(@RequestParam int expenseId , @RequestBody Expense ex){
		return service.updateExpense(expenseId, ex);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<Expense>>> findAllExpense(){
		return service.findAllExpense();
	}


}
