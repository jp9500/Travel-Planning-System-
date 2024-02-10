package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Component
public class ItinararyItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String activity;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Trip trip;
	
}
