package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class TravelAgency 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agencyId;
	private String agencyName;
	private long agencyContact;
	private String agencyEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Trip> trips;
}
