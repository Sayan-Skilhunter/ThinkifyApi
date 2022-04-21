package com.nt.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.nt.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
	
//	private final DriverRepository repository;

	public static ArrayList<Driver> driverList = new ArrayList<Driver>();
	
//	@Autowired
//	public DriverServiceImpl(DriverRepository repository) {
//		this.repository = repository;
//	}

	@Override
	public void addDriver(String driverDetails, String vehicleDetails, String currentLocation) {
		String driverDetailsList[] = driverDetails.replaceAll("\\s+","").split(",");
		String vehicleDetailsList[] = vehicleDetails.replaceAll("\\s+","").split(",");
		Driver driver = new Driver(driverDetailsList[0], driverDetailsList[1], Integer.parseInt(driverDetailsList[2]), vehicleDetailsList[0], vehicleDetailsList[1], currentLocation, true);
		driverList.add(driver);
	}

	@Override
	public void updateDriverLocation(String driverName, String currentLocation) {
		for(Driver obj : driverList) {
			if(obj.getDriverName().equals(driverName)) {
				obj.setCurrentLocation(currentLocation);
			}
		}
	}

	@Override
	public void changeDriverStatus(String driverName, boolean driverStatus) {
		for(Driver obj : driverList) {
			if(obj.getDriverName().equals(driverName)) {
				obj.setDriverStatus(driverStatus);
			}
		}	
	}

}
