package com.kavs.placement;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class PlacementRepositoryTest {
	
	@Autowired
    private PlacementRepository plRepo;
	
	@Test
    //JUnit Test for Saving records
    public void testSavePlacement()
    {
        Placement pl = new Placement();
        pl.setName("John Doe");
        pl.setId(12);
        pl.setCollegename("Example College");
        pl.setCompanyname("Example Company");
        pl.setQualification("MBA");
        pl.setYear(2022);
        pl.setStatus("Pending");
        
        Placement savedPlacement = plRepo.save(pl);

     // for testing whether id is greater than 0 or not.
        assertNotNull(savedPlacement.getId()); 
        Assertions.assertThat(savedPlacement.getId()).isGreaterThan(0);
        
        //Testing for Equality of values
		
		 assertEquals("John Doe", savedPlacement.getName()); 
		 assertEquals(12,savedPlacement.getId());
		 assertEquals("Example College",savedPlacement.getCollegename()); 
		 assertEquals("Example Company",savedPlacement.getCompanyname()); 
		 assertEquals("MBA",savedPlacement.getQualification()); 
		 assertEquals(2022,savedPlacement.getYear());
		 assertEquals("Pending",savedPlacement.getStatus());
}	
    
	@Test
	public void testDeletePlacement() 
	{
		Placement pl = new Placement();
		 pl.setName("John Doe");
	     pl.setId(12);
	     pl.setCollegename("Example College");
	     pl.setCompanyname("Example Company");
	     pl.setQualification("MBA");
	     pl.setYear(2022);
	     pl.setStatus("Pending");

		 Placement saved = plRepo.save(pl);
		 int placementId = saved.getId();

		        // Delete the placement
		        plRepo.deleteById(placementId);

		        // Verify the deletion
		        assertFalse(plRepo.findById(placementId).isPresent());
		 
}
}
