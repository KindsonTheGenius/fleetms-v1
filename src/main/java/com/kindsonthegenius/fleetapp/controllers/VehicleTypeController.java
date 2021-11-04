package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired  private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicleTypes")
	public String getVehicleTypes(Model model) {		
		
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();	
	
		model.addAttribute("vehicleTypes", vehicleTypeList);
		return "vehicleType";
	}	
	
	@PostMapping("/vehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping("vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
	  return vehicleTypeService.findById(id);	
	}	
	
	@RequestMapping(value="/vehicleTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping(value="/vehicleTypes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}
}
