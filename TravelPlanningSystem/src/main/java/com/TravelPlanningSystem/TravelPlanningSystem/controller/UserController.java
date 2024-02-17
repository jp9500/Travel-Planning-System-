package com.TravelPlanningSystem.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.Userservice;
import com.TravelPlanningSystem.TravelPlanningSystem.dto.Userdto;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	Userservice service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Userdto>> saveUser(@Valid @RequestBody User user, BindingResult result){
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Userdto>> findUser(@RequestParam int userId){
		return service.findUser(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int userId){
		return service.deleteUser(userId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int userId , @RequestBody User u){
		return service.updateUser(userId , u);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		return service.findAllUser();
	}
	
	@PutMapping("assignAgency")
	public ResponseEntity<ResponseStructure<User>> assignAgency(@RequestParam int userId ,@RequestParam int agencyId){
		return service.assignAgency(userId, agencyId);
	}
	
	@PutMapping("assignTrip")
	public ResponseEntity<ResponseStructure<User>> assignTrip(@RequestParam int userId ,@RequestParam int tripId){
		return service.assignTrip(userId, tripId);
	}
	
	@GetMapping("email")
	public ResponseEntity<ResponseStructure<User>> findByemail(@RequestParam String email){
		return service.findByEmail(email);
	}
	
	@GetMapping("login")
	public ResponseEntity<ResponseStructure<User>> userLogin(@RequestBody User user){
		return service.userLogin(user);
	}
}
