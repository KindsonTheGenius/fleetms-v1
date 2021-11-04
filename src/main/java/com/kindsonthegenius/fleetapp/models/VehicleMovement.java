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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMovement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private int vehicleid;
	
	@ManyToOne
	@JoinColumn(name="locationid1", insertable=false, updatable=false)
	private Location location1;
	private int locationid1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date date1;
	
	@ManyToOne
	@JoinColumn(name="locationid2", insertable=false, updatable=false)
	private Location location2;
	private int locationid2;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")		
	private Date date2;

	private String remarks;
}
