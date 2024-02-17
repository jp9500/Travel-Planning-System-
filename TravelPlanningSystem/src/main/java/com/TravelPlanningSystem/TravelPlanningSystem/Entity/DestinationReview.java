package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class DestinationReview
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String destination;
	@Positive
	@Min(value = 0)
	private double ratings;
	private String command;
	
}
