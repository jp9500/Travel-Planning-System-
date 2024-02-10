package com.TravelPlanningSystem.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.DestinationReview;
import com.TravelPlanningSystem.TravelPlanningSystem.Repo.DestinationReviewrepo;

@Repository
public class DestinationReviewdao 
{
	@Autowired
	DestinationReviewrepo repo ;
	
	public DestinationReview saveReview(DestinationReview review) {
		return repo.save(review);
	}
	
	public DestinationReview findReview(int reviewId) {
		Optional<DestinationReview> opReview=repo.findById(reviewId);
		if(opReview.isPresent()) {
			return opReview.get();
		}
		return null;
	}
	
	public DestinationReview deleteReview(int reviewId) {
		DestinationReview exReview=findReview(reviewId);
		if(exReview != null) {
			repo.deleteById(reviewId);
			return exReview;
		}
		return null;
	}
	
	public DestinationReview updateReview(int reviewId , DestinationReview rev) {
		DestinationReview exReview=findReview(reviewId);
		if(exReview != null) {
			rev.setReviewId(reviewId);
			return repo.save(rev);
		}
		return null;
	}
	
	public List<DestinationReview> findAllReview(){
		return repo.findAll();
	}

}