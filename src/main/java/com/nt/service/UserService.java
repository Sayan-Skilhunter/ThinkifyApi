package com.nt.service;

public interface UserService {

	public void addUser(String userDetails);
	
	public void updateUser(String userName, String updatedDetails);
	
	public void updateUserLocation(String userName, String Location);
	
}
