package de.uebung4_5.uni;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class Adresse {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id; 
	
	private String strasseHNr; 
	private String PLZOrt; 
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Student student; 
	
	public Adresse() {}
	
	public Adresse(String strasseHNr, String PLZOrt, Student student) {
		this.strasseHNr = strasseHNr; 
		this.PLZOrt = PLZOrt; 
		this.student = student; 
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public String getPLZOrt() {
		return PLZOrt;
	}

	public void setPLZOrt(String pLZOrt) {
		PLZOrt = pLZOrt;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
