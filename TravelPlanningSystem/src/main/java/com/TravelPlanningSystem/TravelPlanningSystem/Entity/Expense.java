package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseId;
	private String description;
	@Positive
	@Min(value = 0)
	private double amount;
	private LocalDate expenseDate;
	
}
