package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Return list of suppliers
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	//SAve new supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}

}
