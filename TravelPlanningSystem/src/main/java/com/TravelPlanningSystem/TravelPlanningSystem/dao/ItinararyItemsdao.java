package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.ItinararyItem;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.ItinararyItemsRepo;

@Repository
public class ItinararyItemsdao
{
	@Autowired
	ItinararyItemsRepo repo;
	
	public ItinararyItem saveItem(ItinararyItem item) {
		return repo.save(item);
	}
	
	public ItinararyItem findItem(int itemId) {
		Optional<ItinararyItem> opItem =repo.findById(itemId);
		if(opItem.isPresent()) {
			return opItem.get();
		}
		return null;
	}
	
	public ItinararyItem deleteItem(int itemId) {
		ItinararyItem exItem =findItem(itemId);
		if(exItem != null) {
			repo.deleteById(itemId);
			return exItem;
		}
		return null;
	}
	
	public ItinararyItem updateItem(int itemId,ItinararyItem item) {
		ItinararyItem exItem =findItem(itemId);
		if(exItem != null) {
			item.setItemId(itemId);
			return repo.save(item);
		}
		return null;
	}
	
	public List<ItinararyItem> findAllItems(){
		return repo.findAll();
	}

}
