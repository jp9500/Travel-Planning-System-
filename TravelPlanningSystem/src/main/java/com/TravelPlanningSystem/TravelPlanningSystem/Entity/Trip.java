package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "Destination can't be null")
	@NotBlank(message = "Destination can't be blank")
	private String destination;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private TransportationType transportationType;
	private AccomodationType accomodationType;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<ItinararyItem> items;
	@OneToMany(cascade = CascadeType.ALL)
	List<Expense> expense;
	@OneToMany(cascade = CascadeType.ALL)
	List<DestinationReview> reviews;
	
}
