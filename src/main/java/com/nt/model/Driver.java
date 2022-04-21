package com.nt.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//@Entity
@Data
@NoArgsConstructor
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String driverName;
	private String gender;
	private Integer age;
	private String vehicleModel;
	private String vehicleNumber;
	@NonNull
	private String currentLocation;
	private boolean driverStatus;
	private Integer earning;
	
	public Driver(@NonNull String driverName, String gender, Integer age, String vehicleModel, String vehicleNumber,
			String currentLocation, boolean driverStatus) {
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
		this.vehicleModel = vehicleModel;
		this.vehicleNumber = vehicleNumber;
		this.currentLocation = currentLocation;
		this.driverStatus = driverStatus;
		this.earning = 0;
	}
	
}
