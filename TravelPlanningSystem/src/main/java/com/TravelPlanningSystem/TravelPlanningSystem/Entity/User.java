package com.TravelPlanningSystem.TravelPlanningSystem.Entity;

import java.util.List;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Component
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message = "Username can't be null")
	@NotBlank(message = "Username can't be blank")
	private String userName;
	
	@NotNull(message = "UserEmail can't be null" )
	@NotBlank(message = "UserEmail can't be blank" )
	private String userEmail;
	
	@NotNull(message = "Password can't be null" )
	@NotBlank(message = "Password can't be blank" )
	@Pattern(regexp = "^(?=.[A-Z])(?=.[a-z])(?=.[0-9])(?=.[!@#$%^&*+=_-]).{8,}$", 
			 message = "Enter the valid password!")
	private String userPassword;
	
	@OneToOne(cascade = CascadeType.ALL)
	TravelAgency agency;
	@OneToMany(cascade = CascadeType.ALL)
	List<Trip> trips;
}