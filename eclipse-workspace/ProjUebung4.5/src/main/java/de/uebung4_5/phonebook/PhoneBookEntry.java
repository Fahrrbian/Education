package de.uebung4_5.phonebook;

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
}
