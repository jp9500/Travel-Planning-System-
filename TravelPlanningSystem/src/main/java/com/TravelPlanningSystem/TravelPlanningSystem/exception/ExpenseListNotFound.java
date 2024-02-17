package com.TravelPlanningSystem.TravelPlanningSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ExpenseListNotFound extends RuntimeException{
	String msg;
}
