package com.TravelPlanningSystem.TravelPlanningSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;

public interface Triprepo extends JpaRepository<Trip, Integer>{
	
}
