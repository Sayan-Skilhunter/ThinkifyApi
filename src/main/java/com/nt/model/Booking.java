package com.nt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Booking {

	private String userName;
	private String driverName;
	private String startLoc;
	private String endLoc;
	private Integer bill;
}
