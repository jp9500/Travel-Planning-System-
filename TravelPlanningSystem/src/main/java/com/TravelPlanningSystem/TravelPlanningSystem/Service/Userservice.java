package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Userdao;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class Userservice 
{
	@Autowired
	Userdao udao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> str = new ResponseStructure<User>();
		str.setMsg(" User Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(udao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int id){
		ResponseStructure<User> str = new ResponseStructure<User>();
		User exUser=udao.findUser(id);
		if(exUser != null) {
			str.setMsg("User found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exUser);
			return new ResponseEntity<ResponseStructure<User>>(str, HttpStatus.FOUND);
		}
		return null;
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
		return null;
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
		return null;
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
		return null;
	}
}
