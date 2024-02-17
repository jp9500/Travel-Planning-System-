package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TravelAgency;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.Userrepo;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.TravelAgencydao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Tripdao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Userdao;
import com.TravelPlanningSystem.TravelPlanningSystem.dto.Userdto;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TravelAgencyNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TripNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.UserListNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.userNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;
import com.mysql.cj.protocol.result.AbstractResultsetRow;

@Service
public class Userservice 
{
	@Autowired
	Userdao udao;
	
	@Autowired
	Tripdao tdao;
	
	@Autowired
	TravelAgencydao adao;
	
	public ResponseEntity<ResponseStructure<Userdto>> saveUser(User user){
		User u = udao.saveUser(user);
		Userdto dto =new Userdto();
		ModelMapper map =new ModelMapper();
		map.map(u, dto);
		ResponseStructure<Userdto> str = new ResponseStructure<Userdto>();
		str.setMsg(" User Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(dto);
		return new ResponseEntity<ResponseStructure<Userdto>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Userdto>> findUser(int id){
		User exUser=udao.findUser(id);
		Userdto dto =new Userdto();
		ModelMapper map =new ModelMapper();
		map.map(exUser, dto);
		ResponseStructure<Userdto> str = new ResponseStructure<Userdto>();
		if(exUser != null) {
			str.setMsg("User found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(dto);
			return new ResponseEntity<ResponseStructure<Userdto>>(str, HttpStatus.FOUND);
		}
		throw new userNotFound("User does not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		ResponseStructure<User> str = new ResponseStructure<User>();
		User exUser=udao.findUser(id);
		if(exUser != null) {
			str.setMsg("User found Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(udao.deleteUser(id));
			return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.OK);
		}
		throw new userNotFound("User does not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id , User u){
		ResponseStructure<User> str = new ResponseStructure<User>();
		User exUser=udao.findUser(id);
		if(exUser != null) {
			str.setMsg("User found Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(udao.updateUser(id, u));
			return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.OK);
		}
		throw new userNotFound("User does not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		ResponseStructure<List<User>> str = new ResponseStructure<List<User>>();
		List<User> users =udao.findAllUser();
		if(!users.isEmpty()) {
			str.setMsg("All user Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(users);
			return new ResponseEntity<ResponseStructure<List<User>>>(str , HttpStatus.FOUND);
		}
		throw new UserListNotFound("User List does not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> assignAgency(int userId , int agencyId){
		ResponseStructure<User> str = new ResponseStructure<User>();
		User u =udao.findUser(userId);
		TravelAgency agency =adao.findAgency(agencyId);
		if(u != null) {
			if(agency != null) {
				u.setAgency(agency);
				str.setMsg("Agency assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(udao.updateUser(userId, u));
				return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.OK);
			}
			throw new TravelAgencyNotFound("Agency does not Found");
		}
		throw new userNotFound("User does not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> assignTrip(int userId , int tripId){
		ResponseStructure<User> str = new ResponseStructure<User>();
		User u =udao.findUser(userId);
		Trip t =tdao.findTrip(tripId);
		if(u != null) {
			if(t != null) {
				u.getTrips().add(t);
				str.setMsg("Trip assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(udao.updateUser(userId, u));
				return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.OK);
			}
			throw new TripNotFound("Trip does not Found");
		}
		throw new userNotFound("User does not Found");
	}
	
	public ResponseEntity<ResponseStructure<User>> findByEmail(String email){
		ResponseStructure<User> str = new ResponseStructure<User>();
		
		str.setMsg("email Found");
		str.setCode(HttpStatus.FOUND.value());
		str.setData(udao.findByuserEmail(email));
		return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> userLogin(User user) {
		 User byUserEmail = udao.findByuserEmail(user.getUserEmail());
		 System.err.println(byUserEmail);

		    if (user.getUserEmail() != null && byUserEmail != null) {
		        
		        if (user.getUserEmail().equals(byUserEmail.getUserEmail()) &&
		            user.getUserPassword().equals(byUserEmail.getUserPassword())) {

		            ResponseStructure<User> structure = new ResponseStructure<User>();
		          
		            structure.setMsg("Login Success");
		            structure.setCode(HttpStatus.OK.value());
		            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		        }
		    }
		    ResponseStructure<User> errorStructure = new ResponseStructure<User>();
		    errorStructure.setMsg("Login failed");
		    errorStructure.setCode(HttpStatus.UNAUTHORIZED.value());

		    return new ResponseEntity<ResponseStructure<User>>(errorStructure, HttpStatus.UNAUTHORIZED);
		}
}
