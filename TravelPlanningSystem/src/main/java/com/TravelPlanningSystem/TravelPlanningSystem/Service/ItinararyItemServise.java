package com.TravelPlanningSystem.TravelPlanningSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TravelPlanningSystem.TravelPlanningSystem.Entity.ItinararyItem;
import com.TravelPlanningSystem.TravelPlanningSystem.Entity.User;
import com.TravelPlanningSystem.TravelPlanningSystem.dao.ItinararyItemsdao;
import com.TravelPlanningSystem.TravelPlanningSystem.util.ResponseStructure;

@Service
public class ItinararyItemServise 
{
	@Autowired
	ItinararyItemsdao idao;
	
	public ResponseEntity<ResponseStructure<ItinararyItem>> saveItem(ItinararyItem item){
		ResponseStructure<ItinararyItem> str = new ResponseStructure<ItinararyItem>();
		str.setMsg(" Item Saved Success");
		str.setCode(HttpStatus.CREATED.value());
		str.setData(idao.saveItem(item));
		return new ResponseEntity<ResponseStructure<ItinararyItem>>(str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<ItinararyItem>> findItem(int id){
		ResponseStructure<ItinararyItem> str = new ResponseStructure<ItinararyItem>();
		ItinararyItem exItem=idao.findItem(id);
		if(exItem != null) {
			str.setMsg("Item found Success");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(exItem);
			return new ResponseEntity<ResponseStructure<ItinararyItem>>(str, HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ItinararyItem>> deleteItem(int id){
		ResponseStructure<ItinararyItem> str = new ResponseStructure<ItinararyItem>();
		ItinararyItem exItem=idao.findItem(id);
		if(exItem != null) {
			str.setMsg("Item deleted Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(idao.deleteItem(id));
			return new ResponseEntity<ResponseStructure<ItinararyItem>>(str, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ItinararyItem>> updateItem(int id ,ItinararyItem item){
		ResponseStructure<ItinararyItem> str = new ResponseStructure<ItinararyItem>();
		ItinararyItem exItem=idao.findItem(id);
		if(exItem != null) {
			str.setMsg("Item updated Success");
			str.setCode(HttpStatus.OK.value());
			str.setData(idao.updateItem(id , item));
			return new ResponseEntity<ResponseStructure<ItinararyItem>>(str, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<ItinararyItem>>> findAllItem(){
		ResponseStructure<List<ItinararyItem>> str = new ResponseStructure<List<ItinararyItem>>();
		List<ItinararyItem> items =idao.findAllItems();
		if(!items.isEmpty()) {
			str.setMsg("All Items Found");
			str.setCode(HttpStatus.FOUND.value());
			str.setData(items);
			return new ResponseEntity<ResponseStructure<List<ItinararyItem>>>(str , HttpStatus.FOUND);
		}
		return null;
	}

	
}
