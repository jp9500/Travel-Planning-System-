package com.TravelPlanningSystem.TravelPlanningSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Integer>{

}
