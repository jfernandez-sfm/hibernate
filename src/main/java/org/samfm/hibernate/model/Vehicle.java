package org.samfm.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Vehicle {
	
	@Id 
	@GeneratedValue(generator="vehicles_seq")
	@SequenceGenerator(name="vehicles_seq", allocationSize=1)
	private int vehicleId;
	private String vechicleName;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDetails userDetails;
	
	public Vehicle() {
		
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVechicleName() {
		return vechicleName;
	}

	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}

	
}
