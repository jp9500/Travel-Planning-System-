package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.DestinationReview;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TravelAgency;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.Trip;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.TravelAgencydao;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.Tripdao;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TravelAgencyListNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TravelAgencyNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.TripNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TravelAgencyService 
{
	@Autowired
	TravelAgencydao adao;
	
	@Autowired
	Tripdao tdao;
	
	public ResponseEntity<ResponseStructure<TravelAgency>> saveAgency(TravelAgency agency){
		ResponseStructure<TravelAgency> str = new ResponseStructure<TravelAgency>();
		str.setMsg(" Agency Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(adao.saveTravelAgency(agency));
		return new ResponseEntity<ResponseStructure<TravelAgency>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> findAgency(int agencyId){
		ResponseStructure<TravelAgency> str = new ResponseStructure<TravelAgency>();
		TravelAgency exAgency=adao.findAgency(agencyId);
		if(exAgency != null) {
			str.setMsg("Agency found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exAgency);
			return new ResponseEntity<ResponseStructure<TravelAgency>>(str, HttpStatus.FOUND);
		}
		throw new TravelAgencyNotFound("Agency does not Found");
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> deleteAgency(int agencyId){
		ResponseStructure<TravelAgency> str = new ResponseStructure<TravelAgency>();
		TravelAgency exAgency=adao.findAgency(agencyId);
		if(exAgency != null) {
			str.setMsg("Agency deleted Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(adao.deleteAgency(agencyId));
			return new ResponseEntity<ResponseStructure<TravelAgency>>(str, HttpStatus.OK);
		}
		throw new TravelAgencyNotFound("Agency does not Found");
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> updateAgency(int agencyId ,TravelAgency agency){
		ResponseStructure<TravelAgency> str = new ResponseStructure<TravelAgency>();
		TravelAgency exAgency=adao.findAgency(agencyId);
		if(exAgency != null) {
			str.setMsg("Agency updated Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(adao.updateAgency(agencyId , agency));
			return new ResponseEntity<ResponseStructure<TravelAgency>>(str, HttpStatus.OK);
		}
		throw new TravelAgencyNotFound("Agency does not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<TravelAgency>>> findAllAgency(){
		ResponseStructure<List<TravelAgency>> str = new ResponseStructure<List<TravelAgency>>();
		List<TravelAgency> agencies =adao.findAllAgencies();
		if(!agencies.isEmpty()) {
			str.setMsg("All Agencies Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(agencies);
			return new ResponseEntity<ResponseStructure<List<TravelAgency>>>(str , HttpStatus.FOUND);
		}
		throw new TravelAgencyListNotFound("Agency List does not Found");
	}
	
	public ResponseEntity<ResponseStructure<Trip>> assignTrip(int agencyId, int tripId){
		ResponseStructure<Trip> str = new ResponseStructure<Trip>();
		TravelAgency agency=adao.findAgency(agencyId);
		Trip t = tdao.findTrip(tripId);
		if(agency != null) {
			if(t != null) {
				agency.getTrips().add(t);
				str.setMsg("Trip assign Success");
				str.setCode(HttpStatus.OK.value());
				str.setData(tdao.updateTrip(tripId, t));
				return new ResponseEntity<ResponseStructure<Trip>>(str, HttpStatus.OK);
			}
			return null;
		}
		throw new TripNotFound("Trip does not Found");
	}
	
}
