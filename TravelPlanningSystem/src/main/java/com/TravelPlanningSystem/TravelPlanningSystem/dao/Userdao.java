package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.Userrepo;
@Repository
public class Userdao 
{
	@Autowired
	Userrepo repo ;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User findUser(int userId) {
		Optional<User> opUser=repo.findById(userId);
		if(opUser.isPresent()) {
			return opUser.get();
		}
		return null;
	}
	
	public User deleteUser(int userId) {
		User user=findUser(userId);
		if(user != null) {
			repo.deleteById(userId);
			return user;
		}
		return null;
	}
	
	public User updateUser(int userId , User u) {
		User user=findUser(userId);
		if(user != null) {
			u.setUserId(user.getUserId());
			return repo.save(u);
		}
		return null;
	}
	
	public List<User> findAllUser(){
		return repo.findAll();
	}
	
	public User findByuserEmail(String email) {
		return repo.findByuserEmail(email);
	}
}
