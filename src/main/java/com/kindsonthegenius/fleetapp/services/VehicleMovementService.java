package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//Return list of vehicleMovements
	public List<VehicleMovement> getVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}
	
	//SAve new vehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//get by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}

}
