package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.DestinationReview;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.DestinationReviewdao;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.DestinationReviewNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.exception.destinationReviewListNotFound;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class DestinationReviewService {
	
	@Autowired
	DestinationReviewdao ddao;

	public ResponseEntity<ResponseStructure<DestinationReview>> saveReview(DestinationReview review){
		ResponseStructure<DestinationReview> str = new ResponseStructure<DestinationReview>();
		str.setMsg(" Review Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(ddao.saveReview(review));
		return new ResponseEntity<ResponseStructure<DestinationReview>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> findReview(int id){
		ResponseStructure<DestinationReview> str = new ResponseStructure<DestinationReview>();
		DestinationReview exReview=ddao.findReview(id);
		if(exReview != null) {
			str.setMsg("Review found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exReview);
			return new ResponseEntity<ResponseStructure<DestinationReview>>(str, HttpStatus.FOUND);
		}
		throw new DestinationReviewNotFound("Review does not Found");
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> deleteReview(int id){
		ResponseStructure<DestinationReview> str = new ResponseStructure<DestinationReview>();
		DestinationReview exReview=ddao.findReview(id);
		if(exReview != null) {
			str.setMsg("Review deleted Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(ddao.deleteReview(id));
			return new ResponseEntity<ResponseStructure<DestinationReview>>(str, HttpStatus.OK);
		}
		throw new DestinationReviewNotFound("Review does not Found");
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> updateReview(int id,DestinationReview rev){
		ResponseStructure<DestinationReview> str = new ResponseStructure<DestinationReview>();
		DestinationReview exReview=ddao.findReview(id);
		if(exReview != null) {
			str.setMsg("Review updated Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(ddao.updateReview(id,rev));
			return new ResponseEntity<ResponseStructure<DestinationReview>>(str, HttpStatus.OK);
		}
		throw new DestinationReviewNotFound("Review does not Found");
	}
	public ResponseEntity<ResponseStructure<List<DestinationReview>>> findAllReview(){
		ResponseStructure<List<DestinationReview>> str = new ResponseStructure<List<DestinationReview>>();
		List<DestinationReview> reviews =ddao.findAllReview();
		if(!reviews.isEmpty()) {
			str.setMsg("All Reviews Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(reviews);
			return new ResponseEntity<ResponseStructure<List<DestinationReview>>>(str , HttpStatus.FOUND);
		}
		throw new destinationReviewListNotFound("Review List does not Found");
	}
	
	
}
