package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Expense;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Expensedao;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.ExpenseListNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.ExpenseNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class ExpenseService 
{
	@Autowired
	Expensedao edao;
	
	public ResponseEntity<ResponseStructure<Expense>> saveExpense(Expense ex){
		ResponseStructure<Expense> str = new ResponseStructure<Expense>();
		str.setMsg("Expense save Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(edao.saveExpense(ex));
		return new ResponseEntity<ResponseStructure<Expense>>(str ,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Expense>> findExpense(int id){
		ResponseStructure<Expense> str = new ResponseStructure<Expense>();
		Expense exExpense=edao.findExpense(id);
		if(exExpense != null) {
			str.setMsg("Expense found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exExpense);
			return new ResponseEntity<ResponseStructure<Expense>>(str, HttpStatus.FOUND);
		}
		throw new ExpenseNotFound("Expense does not found");
	}
	
	public ResponseEntity<ResponseStructure<Expense>> deleteExpense(int id){
		ResponseStructure<Expense> str = new ResponseStructure<Expense>();
		Expense exExpense=edao.findExpense(id);
		if(exExpense != null) {
			str.setMsg("Expense deleted Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(edao.deleteExpense(id));
			return new ResponseEntity<ResponseStructure<Expense>>(str, HttpStatus.OK);
		}
		throw new ExpenseNotFound("Expense does not found");
	}
	
	public ResponseEntity<ResponseStructure<Expense>> updateExpense(int expenseId, Expense exp){
		ResponseStructure<Expense> str = new ResponseStructure<Expense>();
		Expense exExpense=edao.findExpense(expenseId);
		if(exExpense != null) {
			str.setMsg("Expense updated Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(edao.updateExpense(expenseId, exExpense));
			return new ResponseEntity<ResponseStructure<Expense>>(str, HttpStatus.OK);
		}
		throw new ExpenseNotFound("Expense does not found");
	}
	
	public ResponseEntity<ResponseStructure<List<Expense>>> findAllExpense(){
		ResponseStructure<List<Expense>> str = new ResponseStructure<List<Expense>>();
		List<Expense> exs =edao.findAllExpenses();
		if(!exs.isEmpty()) {
			str.setMsg("All Expenses Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exs);
			return new ResponseEntity<ResponseStructure<List<Expense>>>(str , HttpStatus.FOUND);
		}
		throw new ExpenseListNotFound("Expense List does not found");
	}
}
