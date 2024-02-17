package com.TravelPlanningSystem.TravelPlanningSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class destinationReviewListNotFound extends RuntimeException{
	String msg;
}
