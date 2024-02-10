package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Tripdao;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TripService 
{
	@Autowired
	Tripdao tdao;
	
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(Trip trip){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
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
		return null;
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
		return null;
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
		return null;
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
		return null;
	}

}
