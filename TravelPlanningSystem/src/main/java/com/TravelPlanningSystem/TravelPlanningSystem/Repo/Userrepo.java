package com.TravelPlanningSystem.TravelPlanningSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;

public interface Userrepo extends JpaRepository<User, Integer>{
	
}
