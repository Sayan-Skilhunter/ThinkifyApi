package com.nt.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.nt.model.User;

@Service
public class UserServiceImpl implements UserService {
	
//	private final UserRepository repository;
	
	public static ArrayList<User> userList = new ArrayList<User>();
	
//	@Autowired
//	public UserServiceImpl(UserRepository repository) {
//		this.repository = repository;
//	}

	@Override
	public void addUser(String userDetails) throws NullPointerException{
		String args[] = userDetails.replaceAll("\\s+","").split(",");
		User user = new User(args[0], args[1], Integer.parseInt(args[2]), null);
		userList.add(user);
//		repository.save(user);
	}

	@Override
	public void updateUser(String userName, String updatedDetails) {
		String args[] = updatedDetails.replaceAll("\\s+","").split(",");
//		User user = new User();
//		user.setGender(args[0]);
//		user.setAge(Integer.parseInt(args[1]));
//		userList.stream().filter(userObj -> userObj.getUserName().equals(userName)).map(userObj -> { userObj.setGender(args[0]); userObj.setAge(Integer.parseInt(args[1])); });
		for(User obj : userList) {
			if(obj.getUserName().equals(userName)) {
				obj.setGender(args[0]);
				obj.setAge(Integer.parseInt(args[1]));
			}
		}
	}

	@Override
	public void updateUserLocation(String userName, String Location) {
		for(User obj : userList) {
			if(obj.getUserName().equals(userName)) {
				obj.setLocation(Location);
			}
		}
//		repository.updateUserLoc(userName, Location);
	}

}
