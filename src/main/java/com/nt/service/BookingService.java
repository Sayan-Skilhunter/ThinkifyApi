package com.nt.service;

import java.util.List;

public interface BookingService {

	public List<String> findRide(String userName, String startLoc, String endLoc);
	public String chooseRide(String userName, String driverName);
	public String calculateBill(String userName);
}
