package org.samfm.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_details_seq")
	@SequenceGenerator(name="user_details_seq", allocationSize=1)
	private int userId; 
	private String userName;
	@OneToMany(mappedBy="userDetails", cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();


	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name="userId"))
	@GenericGenerator(name="sequence_gen", strategy="sequence")
	
	@CollectionId (columns = {@Column (name="addressId")},	
					generator = "sequence_gen", type = @Type(type="long"))
	Collection<Address> listOfAddress = new ArrayList<Address>();
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	
	public void addVehicle(Vehicle vehicle) {
		vehicle.setUserDetails(this);
		getVehicles().add(vehicle);
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}


	public UserDetails() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
