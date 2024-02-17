package com.TravelPlanningSystem.TravelPlanningSystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFoundException(userNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("User does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> tripNotFoundException(TripNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Trip does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> travelAgencyNotFoundException(TravelAgencyNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Agency does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> itinararyItemNotFoundException(ItinararyNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Item does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> expenseNotFoundException(ExpenseNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Expense does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> reviewNotFoundException(DestinationReviewNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Review does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userListNotFoundException(UserListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("User List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> tripListNotFoundException(TripListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Trip List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> travelAgencyListNotFoundException(TravelAgencyListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Agency List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> itinararyItemListNotFoundException(ItinararyListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Item List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> expenseListNotFoundException(ExpenseListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Expense List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> reviewListNotFoundException(destinationReviewListNotFound ex){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setMsg("Review List does not Exist");
		str.setCode(HttpStatus.NOT_FOUND.value());
		str.setData(ex.getMsg());
		return new ResponseEntity<ResponseStructure<String>>(str, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		ResponseStructure<Object> structure = new ResponseStructure<>();
		Map<String, String> hashmap = new HashMap<>();

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMsg("add proper details");
		structure.setCode(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
	}
}
