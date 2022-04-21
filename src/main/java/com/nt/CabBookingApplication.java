package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.service.BookingService;
import com.nt.service.DriverService;
import com.nt.service.UserService;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner{
	
	private final UserService userService;
	
	private final DriverService driverService;
	
	private final BookingService bookingService;

	@Autowired
	public CabBookingApplication(UserService userService, DriverService driverService, BookingService bookingService) {
		this.userService = userService;
		this.driverService = driverService;
		this.bookingService = bookingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			//user entries
			userService.addUser("Abhishek, M, 23");
			userService.updateUserLocation("Abhishek", "0,0");
			
			userService.addUser("Rahul , M, 29");
			userService.updateUserLocation("Rahul","10,0");
			
			userService.addUser("Nandini, F, 22");
			userService.updateUserLocation("Nandini","15,6");
			
			//driver entries
			driverService.addDriver("Driver1, M, 22", "Swift, KA-01-12345", "10,1");
			driverService.addDriver("Driver2, M, 29", "Swift, KA-01-12345", "11,10");
			driverService.addDriver("Driver3, M, 24", "Swift, KA-01-12345", "5,3");
			
			//booking entries
			List<String> availableDriversList= bookingService.findRide("Abhishek", "0,0", "20,1");
			System.out.println(availableDriversList.isEmpty()?"No drivers available":availableDriversList);
			
			availableDriversList= bookingService.findRide("Rahul", "10,0", "15,3");
			System.out.println(availableDriversList.isEmpty()?"No drivers available":availableDriversList);
			
			System.out.println(bookingService.chooseRide("Rahul","Driver1"));
			System.out.println(bookingService.calculateBill("Rahul"));
			driverService.changeDriverStatus("Driver1", false);
			
			availableDriversList= bookingService.findRide("Nandini","15,6", "20,4");
			System.out.println(availableDriversList.isEmpty()?"No drivers available":availableDriversList);
		}
		catch(NullPointerException ne) {
			ne.printStackTrace();
			System.out.println("User name and location cannot be null");
		}
		
		
	}

}
