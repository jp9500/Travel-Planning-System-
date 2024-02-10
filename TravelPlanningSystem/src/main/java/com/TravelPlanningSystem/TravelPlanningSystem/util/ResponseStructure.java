package com.TravelPlanningSystem.TravelPlanningSystem.util;

import lombok.Data;

@Data
public class ResponseStructure <T>
{
	private String msg;
	private int code;
	private T data;
}
