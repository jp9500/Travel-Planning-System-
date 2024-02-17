package com.TravelPlanningSystem.TravelPlanningSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;

public interface Userrepo extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.userEmail= ?1")
	User findByuserEmail(String email);
}
