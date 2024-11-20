package de.uebung4_5.uni;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*; 

@Entity
public class Professor {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 
	
	private String name; 
	@OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
	private Set<Vorlesung> vorlesungen = new HashSet<>(); 
	
	public Professor() {
		
	}
	
	public Professor(String name) {
		
		this.name = name;
		//this.vorlesungen = new vorlesungen<Vorlesung>(); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vorlesung> getVorlesungen() {
		return vorlesungen;
	}

	public void setVorlesungen(Set<Vorlesung> vorlesungen) {
		this.vorlesungen = vorlesungen;
	}
	public void addVorlesung(Vorlesung vorlesung) {
		this.vorlesungen.add(vorlesung);
        vorlesung.setProf(this);
	}
}
