package com.kavs.placement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


//Controller class
@RestController
public class PlacementController {

	//For automatic connection 
	@Autowired
	private PlacementService PS;
	
	@GetMapping("/placement")
	public List<Placement> list() throws Exception
	{
		return PS.ListAll();
	}
	
	//Fetch using Id
	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> collect(@PathVariable Integer id)
	{
		try {
			Placement p = PS.collect(id);
			//response entity should return object type of output
			return new ResponseEntity<Placement>(p,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/placement/add")
	public ResponseEntity<ApiResponse> add(@RequestBody Placement pl)
	{
		 ApiResponse response = PS.save(pl);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PutMapping("/placement/{id}")
	public ResponseEntity<?> Modify(@RequestBody Placement pl, @PathVariable Integer id){
		try {
			Placement oldrecord = PS.collect(id);
			PS.save(pl);
			return new ResponseEntity<> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/placement/{id}")
	public void Remove(@PathVariable Integer id)
	{
		PS.Delete(id);
	}
	
	 @PostMapping("/cancel/{id}")
	 public ResponseEntity<Boolean> Cancel(@PathVariable Integer id) 
	 {
	        boolean success = PS.Cancel(id);
	        return new ResponseEntity<>(success, HttpStatus.OK);
	    }		
}
