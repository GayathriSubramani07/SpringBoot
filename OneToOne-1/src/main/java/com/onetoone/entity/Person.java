package com.onetoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	
	private String name;
	
	private String address;
	
	@OneToOne
	private AadharCard aadhar_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AadharCard getAadhar_id() {
		return aadhar_id;
	}

	public void setAadhar_id(AadharCard aadhar_id) {
		this.aadhar_id = aadhar_id;
	}

	
	

}
