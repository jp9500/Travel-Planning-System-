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

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.DestinationReview;
import com.TravelPlanningSystem.TravelPlanningSystem.Service.DestinationReviewService;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping
public class DestinationReviewController {
	@Autowired
	DestinationReviewService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> saveReview(@RequestBody DestinationReview review){
		return service.saveReview(review);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> findReview(@RequestParam int reviewId){
		return service.findReview(reviewId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> deleteReview(@RequestParam int reviewId){
		return service.deleteReview(reviewId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> updateReview(@RequestParam int reviewId , @RequestBody DestinationReview rev){
		return service.updateReview(reviewId, rev);
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<DestinationReview>>> findAllReview(){
		return service.findAllReview();
	}

}
