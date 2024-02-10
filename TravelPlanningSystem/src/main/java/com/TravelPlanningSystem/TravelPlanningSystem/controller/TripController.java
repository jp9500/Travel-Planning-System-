package com.TravelPlanningSystem.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.TripService;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("trip")
public class TripController {
	@Autowired
	TripService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(@RequestBody Trip trip){
		return service.saveTrip(trip);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Trip>> findTrip(@RequestParam int tripId){
		return service.findTrip(tripId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Trip>> deleteTrip(@RequestParam int tripId){
		return service.deleteTrip(tripId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(@RequestParam int tripId , @RequestBody Trip trip){
		return service.updateTrip(tripId, trip);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrip(){
		return service.findAllTrip();
	}
}
