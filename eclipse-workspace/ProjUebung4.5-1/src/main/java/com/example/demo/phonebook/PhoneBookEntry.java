package com.example.demo.phonebook;

import jakarta.persistence.*; 

@Entity
public class PhoneBookEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	private String name; 
	private String phoneNumber; 
	private boolean isBusiness; 
	
	public PhoneBookEntry(String name, String phoneNumber, boolean isBusiness) {
		super(); 
		this.name = name; 
		this.phoneNumber = phoneNumber; 
		this.isBusiness = isBusiness; 
	}
	public PhoneBookEntry() {
		super(); 
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name; 
	}
	public Long getId() {
		return id; 
	}
	public String getPhoneNumber() {
		return phoneNumber; 
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber; 
	}
	public boolean isBusiness() {
		return isBusiness; 
	}
	public void setBusiness(boolean isBusiness) {
		this.isBusiness =isBusiness; 
	}
   }
