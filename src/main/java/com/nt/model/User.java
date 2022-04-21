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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String userName;
	private String gender;
	private Integer age;
	@NonNull
	private String location;
	
	public User(@NonNull String userName, String gender, Integer age, String location) {
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.location = location;
	}
	
}
