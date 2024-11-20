package de.uebung4_5.uni;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Vorlesung {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 
	
	private String name; 
	private String beschreibung;
	
	@ManyToMany(mappedBy = "vorlesungen", cascade = CascadeType.ALL)
	private Set<Student> studenten = new HashSet<>(); 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Professor prof; 
	
	public Vorlesung() {}; 
	
	public Vorlesung(Professor prof, String beschreibung, String name, Set<Student> studenten) {
		this.name= name; 
		this.beschreibung = beschreibung; 
		this.prof = prof; 
		 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<Student> getStudenten() {
		return studenten;
	}

	public void setStudenten(Set<Student> studenten) {
		this.studenten = studenten;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}	 
}
