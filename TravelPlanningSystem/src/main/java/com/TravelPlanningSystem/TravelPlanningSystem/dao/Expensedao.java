package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Expense;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.ExpenseRepo;
@Repository
public class Expensedao 
{
	@Autowired
	ExpenseRepo repo;
	
	public Expense saveExpense(Expense ex) {
		return repo.save(ex);
	}
	
	public Expense findExpense(int expenseId) {
		Optional<Expense> opEx=repo.findById(expenseId);
		if(opEx.isPresent()) {
			return opEx.get();
		}
		return null;
	}
	
	public Expense deleteExpense(int expenseId) {
		Expense ex=findExpense(expenseId);
		if(ex != null) {
			repo.deleteById(expenseId);
			return ex;
		}
		return null;
	}
	
	public Expense updateExpense(int expenseId , Expense exp) {
		Expense ex=findExpense(expenseId);
		if(ex != null) {
			exp.setExpenseId(expenseId);
			return repo.save(exp);
		}
		return null;
	}
	
	public List<Expense> findAllExpenses(){
		return repo.findAll();
	}
}
