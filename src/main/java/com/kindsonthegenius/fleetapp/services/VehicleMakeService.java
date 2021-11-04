package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//Return list of countries
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}
	
	//SAve new VehicleMake
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}

}
