package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.AccomodationType;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.DestinationReview;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Expense;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.ItinararyItem;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TransportationType;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.DestinationReviewdao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Expensedao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.ItinararyItemsdao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Tripdao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Userdao;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.DestinationReviewNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.ExpenseNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.ItinararyNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TripListNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TripNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.userNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TripService 
{
	@Autowired
	Tripdao tdao;
	
	@Autowired
	Userdao udao;
	
	@Autowired
	ItinararyItemsdao idao;
	
	@Autowired
	Expensedao edao;
	
	@Autowired
	DestinationReviewdao rdao;
	
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(Trip trip , int acValue , int trValue){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		trip.setAccomodationType(saveAccomodationType(acValue));
		trip.setTransportationType(saveTransportationType(trValue));
		str.setMsg(" Trip Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(tdao.saveTrip(trip));
		return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Trip>> findTrip(int tripId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip exTrip=tdao.findTrip(tripId);
		if(exTrip != null) {
			str.setMsg("Trip found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exTrip);
			return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.FOUND);
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> deleteTrip(int tripId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip exTrip=tdao.findTrip(tripId);
		if(exTrip != null) {
			str.setMsg("Trip deleted Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(tdao.deleteTrip(tripId));
			return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(int tripId , Trip trip){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip exTrip=tdao.findTrip(tripId);
		if(exTrip != null) {
			str.setMsg("Trip updated Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(tdao.updateTrip(tripId , trip));
			return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrip(){
		ResponseStructure<List<Trip>> str = new ResponseStructure<List<Trip>>();
		List<Trip> trips =tdao.findAllTrip();
		if(!trips.isEmpty()) {
			str.setMsg("All trips Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(trips);
			return new ResponseEntity<ResponseStructure<List<Trip>>>(str , HttpStatus.FOUND);
		}
		throw new TripListNotFound("Trip List does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> assignItem(int tripId, int itemId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip t = tdao.findTrip(tripId);
		ItinararyItem item =idao.findItem(itemId);
		if(t != null) {
			if(item != null) {
				t.getItems().add(item);
				str.setMsg("Item assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(tdao.updateTrip(tripId, t));
				return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
			}
			throw new ItinararyNotFound("Item does not Found");
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> assignExpense(int tripId, int expId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip t = tdao.findTrip(tripId);
		Expense ex=edao.findExpense(expId);
		if(t != null) {
			if(ex != null) {
				t.getExpense().add(ex);
				str.setMsg("Expense assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(tdao.updateTrip(tripId, t));
				return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
			}
			throw new ExpenseNotFound("Expense does not found");
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> assignReview(int tripId, int reviewId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		Trip t = tdao.findTrip(tripId);
		DestinationReview rev =rdao.findReview(reviewId);
		if(t != null) {
			if(rev != null) {
				t.getReviews().add(rev);
				str.setMsg("Review assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(tdao.updateTrip(tripId, t));
				return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
			}
			throw new DestinationReviewNotFound("Review does not Found");
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	public AccomodationType saveAccomodationType(int value) {
		AccomodationType type=null;
		if(value == 1) {
			type= AccomodationType.AIRBNB;
		}
		else if(value == 2) {
			type= AccomodationType.HOSTEL;
		}
		else if(value == 3) {
			type= AccomodationType.HOTEL;
		}
		return type;
	}
	
	public TransportationType saveTransportationType(int value) {
		TransportationType type=null;
		if(value == 1) {
			type=TransportationType.BUS;
		}
		else if(value == 2) {
			type=TransportationType.CAR;
		}
		else if(value == 3) {
			type=TransportationType.FLIGHT;
		}
		else if(value == 4) {
			type=TransportationType.TRAIN;
		}
		return type;
	}
	
	
}
