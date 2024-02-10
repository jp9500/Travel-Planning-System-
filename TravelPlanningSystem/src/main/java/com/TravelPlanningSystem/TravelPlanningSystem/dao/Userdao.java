package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.Userrepo;

public class Userdao 
{
	Userrepo repo ;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

}
