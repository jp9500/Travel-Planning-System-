package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.Triprepo;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.Userrepo;

@Repository
public class Tripdao 
{
	@Autowired
	Triprepo repo ;
	
	public Trip saveTrip(Trip trip) {
		return repo.save(trip);
	}
	
	public Trip findTrip(int tripId) {
		Optional<Trip> opTrip=repo.findById(tripId);
		if(opTrip.isPresent()) {
			return opTrip.get();
		}
		return null;
	}
	
	public Trip deleteTrip(int tripId) {
		Trip trip=findTrip(tripId);
		if(trip != null) {
			repo.deleteById(tripId);
			return trip;
		}
		return null;
	}
	
	public Trip updateTrip(int tripId , Trip t) {
		Trip trip=findTrip(tripId);
		if(trip != null) {
			t.setTripId(tripId);
			return repo.save(t);
		}
		return null;
	}
	
	public List<Trip> findAllTrip(){
		return repo.findAll();
	}
}
