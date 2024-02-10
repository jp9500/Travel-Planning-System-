package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TravelAgency;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.TravelAgencydao;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TravelAgencyService 
{
	@Autowired
	TravelAgencydao adao;
	
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
		return null;
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
		return null;
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
		return null;
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
		return null;
	}
	
}
