package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.TravelAgency;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.TravelAgencyRepo;

@Repository
public class TravelAgencydao {
	@Autowired
	TravelAgencyRepo repo;
	
	public TravelAgency saveTravelAgency(TravelAgency agency) {
		return repo.save(agency);
	}
	
	public TravelAgency findAgency(int agencyId) {
		Optional<TravelAgency> opAgency=repo.findById(agencyId);
		if(opAgency.isPresent()) {
			return opAgency.get();
		}
		return null;
	}
	
	public TravelAgency deleteAgency(int agencyId) {
		TravelAgency exAgency=findAgency(agencyId);
		if(exAgency != null) {
			repo.deleteById(agencyId);
			return exAgency;
		}
		return null;
	}
	
	public TravelAgency updateAgency(int agencyId , TravelAgency agency) {
		TravelAgency exAgency=findAgency(agencyId);
		if(exAgency != null) {
			agency.setAgencyId(agencyId);
			return repo.save(agency);
		}
		return null;
	}
	
	public List<TravelAgency> findAllAgencies(){
		return repo.findAll();
	}
}
