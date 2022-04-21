package com.nt.service;

public interface DriverService {

	public void addDriver(String driverDetails, String vehicleDetails, String currentLocation);
	
	public void updateDriverLocation(String driverName, String currentLocation);
	
	public void changeDriverStatus(String driverName, boolean driverStatus);

}
