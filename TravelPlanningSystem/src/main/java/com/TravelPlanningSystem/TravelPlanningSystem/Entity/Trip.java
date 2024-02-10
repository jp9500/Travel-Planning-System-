package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Component
public class Trip 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripId;
	private String destination;
	private LocalDate startDate;
	private LocalDate EndtDate;

}
