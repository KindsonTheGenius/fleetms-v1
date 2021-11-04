package com.kindsonthegenius.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.services.SupplierService;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class SupplierController {


	@Autowired	private SupplierService supplierService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;


	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {		
		model.addAttribute("suppliers", supplierService.getSuppliers());	
		
		model.addAttribute("countries", countryService.getCountries());
		
		model.addAttribute("states", stateService.getStates());

		
		return "Supplier";
	}	
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
	  return supplierService.findById(id);	
	}	
	
	@RequestMapping(value="/suppliers/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/suppliers/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
	
}
