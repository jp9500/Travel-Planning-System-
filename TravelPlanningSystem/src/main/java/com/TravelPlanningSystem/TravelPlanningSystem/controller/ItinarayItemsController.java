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

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.ItinararyItem;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.ItinararyItemServise;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("item")
public class ItinarayItemsController {
	@Autowired
	ItinararyItemServise service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ItinararyItem>> saveItem(@RequestBody ItinararyItem item){
		return service.saveItem(item);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ItinararyItem>> findItem(@RequestParam int itemId){
		return service.findItem(itemId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ItinararyItem>> deleteItem(@RequestParam int itemId){
		return service.deleteItem(itemId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ItinararyItem>> updateItem(@RequestParam int itemId , @RequestBody ItinararyItem item){
		return service.updateItem(itemId, item);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<ItinararyItem>>> findAllItem(){
		return service.findAllItem();
	}

}
