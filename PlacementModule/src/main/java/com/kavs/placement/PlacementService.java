package com.kavs.placement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Service Class 
@Service
@Transactional
public class PlacementService {

	@Autowired
	private PlacementRepository RP;
	
	public List<Placement> ListAll() throws Exception
	{
		List<Placement> values = RP.findAll();
		 if (values.isEmpty()) 
		 {
	            throw new Exception("No placements found");
	     }
		 
		return RP.findAll();
	}
	
	public Placement collect(Integer id)
	{
		return RP.findById(id).get();
	}
	
	//Userdefined Exceptions
	private void validatePlacement(Placement pl) {
        if (pl.getName() == null)
        {
            throw new PlValidateException("Student name cannot be null");
        }
        if (pl.getStatus() == null)
        {
            throw new PlValidateException("Status cannot be left Blank..!!");
        }
	}
	public ApiResponse save(Placement pl) {
		validatePlacement(pl);
		Placement saved = RP.save(pl);
		
		//For returning Response 
		ApiResponse response = new ApiResponse();
        response.setSuccess(true);
        response.setMessage("Placement Details saved successfully");
        response.setData(saved);

        return response;
	}
	
	public void Delete(Integer id) {
		RP.deleteById(id);
	}
	
	public boolean Cancel(Integer id)
	{
	        Optional<Placement> optionalPlacement = RP.findById(id);

	        if (optionalPlacement.isPresent())
	        {
	            Placement pl = optionalPlacement.get();
	            // Update the placement status or perform any necessary actions for cancellation
	            pl.setStatus("Cancelled");
	            RP.save(pl);
	            return true; // Successfully cancelled
	        } 
	        else 
	        {
	            return false; // Placement not found
	        }
	}
}
