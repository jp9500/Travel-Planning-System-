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

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TravelAgency;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.TravelAgencyService;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping
public class TravelAgencyController 
{
	@Autowired
	TravelAgencyService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> saveAgency(@RequestBody TravelAgency agency){
		return service.saveAgency(agency);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> findAgency(@RequestParam int agencyId){
		return service.findAgency(agencyId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> deleteAgency(@RequestParam int agencyId){
		return service.deleteAgency(agencyId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> updateAgency(@RequestParam int agencyId , @RequestBody TravelAgency agency){
		return service.updateAgency(agencyId, agency);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<TravelAgency>>> findAllAgency(){
		return service.findAllAgency();
	}

}
