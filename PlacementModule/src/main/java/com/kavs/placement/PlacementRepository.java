package com.kavs.placement;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository Interface
// CRUD methods will be available
public interface PlacementRepository extends JpaRepository<Placement, Integer>{
	
} 
