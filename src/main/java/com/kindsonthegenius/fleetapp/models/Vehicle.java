package com.kindsonthegenius.fleetapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name="vehicletypeid", insertable=false, updatable=false)
	private VehicleType vehicleType;
	private Integer vehicletypeid;	
	
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="vehiclemakeid", insertable=false, updatable=false)
	private VehicleMake vehicleMake;
	private Integer vehiclemakeid;
	
	private String power;
	private String fuelCapacity;
	@ManyToOne
	@JoinColumn(name="vehiclestatusid", insertable=false, updatable=false)
	private VehicleStatus vehicleStatus;
	private Integer vehiclestatusid;	
	
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee inCharge;
	private Integer employeeid;
	
	@ManyToOne
	@JoinColumn(name="vehiclemodelid", insertable=false, updatable=false)
	private VehicleModel vehicleModel;	
	private Integer vehiclemodelid;

	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Integer locationid;
	
	private String remarks;	
}
