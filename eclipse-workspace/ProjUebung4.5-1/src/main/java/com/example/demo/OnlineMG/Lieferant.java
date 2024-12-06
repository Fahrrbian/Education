package com.example.demo.OnlineMG;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Lieferant {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 

	private int hausnummer; 
	private String strasse; 
	private int plz; 
	private String wohnort; 
	private boolean RechnungLiefer; 
	
	@ManyToMany(mappedBy="lieferanten", cascade = CascadeType.PERSIST) 
	private Set<Artikel> artikel = new HashSet<>(); 
	
	public Lieferant(int hausnummer, String strasse, int plz, String wohnort, boolean RechnungLiefer) {
		this.hausnummer = hausnummer; 
		this.strasse = strasse; 
		this.plz = plz; 
		this.wohnort = wohnort;
		this.RechnungLiefer = RechnungLiefer;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public boolean isRechnungLiefer() {
		return RechnungLiefer;
	}

	public void setRechnungLiefer(boolean rechnungLiefer) {
		RechnungLiefer = rechnungLiefer;
	}
	public Set<Artikel> getArtikel() {
		return artikel; 
	}
	public void setArtikel(Set<Artikel> artikel) {
		this.artikel = artikel; 		
	}
}
