package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Booking;
import com.nt.model.Driver;

@Service
public class BookingServiceImpl implements BookingService {
	
	private final DriverService driverService;
	
	private final UserService userService;
	
	private Booking booking; 
	
	@Autowired
	public BookingServiceImpl(DriverService driverService, UserService userService) {
		this.driverService = driverService;
		this.userService = userService;
		this.booking = new Booking(); 
	}

	@Override
	public List<String> findRide(String userName, String startLoc, String endLoc) {
		booking.setUserName(userName);
		booking.setStartLoc(startLoc);
		booking.setEndLoc(endLoc);
		ArrayList<String> nearestDriverList = new ArrayList<String>();
		for(Driver obj : DriverServiceImpl.driverList) {
			if(obj.isDriverStatus()) {
				if (Math.ceil(findDistance(startLoc, obj.getCurrentLocation())) <= 5) {
					nearestDriverList.add(obj.getDriverName());
				}
			}
		}
		return nearestDriverList;
	}

	@Override
	public String chooseRide(String userName, String driverName) {
		booking.setDriverName(driverName);
		driverService.changeDriverStatus(driverName, false);
		return "Ride Started";
	}

	@Override
	public String calculateBill(String userName) {
		Integer bill = (int)Math.ceil(findDistance(booking.getStartLoc(), booking.getEndLoc()));
		booking.setBill(bill);
		userService.updateUserLocation(userName, booking.getEndLoc());
		driverService.updateDriverLocation(booking.getDriverName(), booking.getEndLoc());
//		DriverServiceImpl.driverList.stream().filter(driver -> driver.getDriverName().equals(booking.getDriverName())).collect(Collectors.toList());
		for(Driver driver : DriverServiceImpl.driverList) {
			if(driver.getDriverName().equals(booking.getDriverName())) {
				driver.setEarning(driver.getEarning() + booking.getBill());
			}
		}
		return "Ride ended, bill amount $ " + bill;
	}
	
	private Double findDistance(String startLoc, String endLoc) {
		String[] startPoints = startLoc.split(",");
		String[] endPoints = endLoc.split(",");
		return Math.sqrt(Math.pow(Double.parseDouble(startPoints[0]) - Double.parseDouble(endPoints[0]), 2) + 
				Math.pow(Double.parseDouble(startPoints[1]) - Double.parseDouble(endPoints[1]), 2));
	}

}
