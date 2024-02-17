package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
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
public class TravelAgency 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agencyId;
	
	@NotNull(message = "Agency name can't be null")
	@NotBlank(message = "Agency name can't be blank")
	private String agencyName;
	
	@Positive
	@Min(value = 6000000000L)
	@Max(value = 9999999999L)
	private long agencyContact;
	
	@NotNull(message = "Agency E-mail can't be null")
	@NotBlank(message = "Agency E-mail can't be blank")
	private String agencyEmail;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Trip> trips;
}
