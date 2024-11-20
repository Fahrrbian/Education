package de.uebung4_5.uni;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 
	
	private String vorname; 
	private String nachname; 
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_vorlesung",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "vorlesung_id")
    )
	private Set<Vorlesung> vorlesungen = new HashSet<>(); 
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.PERSIST)
	private Adresse adresse; 
	
	public Student() {
		
	}
	
	public Student(String nachname, String vorname) {
		this.nachname= nachname; 
		this.vorname = vorname;		 
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Set<Vorlesung> getVorlesungen() {
		return vorlesungen;
	}

	public void setVorlesungen(Set<Vorlesung> vorlesungen) {
		this.vorlesungen = vorlesungen;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public void addVorlesung(Vorlesung vorlesung) {
		 this.vorlesungen.add(vorlesung);
	     vorlesung.getStudenten().add(this);
	}
}
