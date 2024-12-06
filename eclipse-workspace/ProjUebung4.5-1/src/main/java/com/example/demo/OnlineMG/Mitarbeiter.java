package com.example.demo.OnlineMG;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Mitarbeiter {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 

	private String benutzername; 
	private int einstellungsdatum; 
	private String email; 
	private String nachname; 
	private String vorname; 
	private String passwort; 
	
	@OneToMany(mappedBy ="mitarbeiter", cascade =CascadeType.ALL, orphanRemoval = true)
	private Set<Artikel> artikel = new HashSet<>(); 
	
	public Mitarbeiter() {}
	
	public Mitarbeiter(String benutzername, int einstellungsdatum, String email, String nachname, String vorname, String passwort) {
		this.benutzername = benutzername; 
		this.einstellungsdatum = einstellungsdatum; 
		this.email = email; 
		this.nachname = nachname; 
		this.vorname = vorname; 
		this.passwort = passwort; 
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public int getEinstellungsdatum() {
		return einstellungsdatum;
	}

	public void setEinstellungsdatum(int einstellungsdatum) {
		this.einstellungsdatum = einstellungsdatum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public Set<Artikel> getArtikel() {
		return artikel; 
	}
	public void setArtikel(Set<Artikel> artikel) {
		this.artikel = artikel; 
	}
}
