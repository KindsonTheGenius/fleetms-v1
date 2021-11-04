package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//Return list of countries
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}
	
	//SAve new EmployeeType
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	//get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
	}


}
