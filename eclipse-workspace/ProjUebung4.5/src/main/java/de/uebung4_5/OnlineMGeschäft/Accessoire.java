package de.uebung4_5.OnlineMGeschäft;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;





//@DiscriminatorValue("ACCESSOIRE")
@Entity
public class Accessoire extends Artikel {
 	 
	
	private boolean eineGroesse; 
	private double breite; 
	private double laenge; 
	private double hoehe; 
	
	public Accessoire() {
		super(); 
	}
	
	
	public Accessoire(boolean eineGroesse, double laenge, double breite, double hoehe) {
		super(); 
		this.eineGroesse = eineGroesse; 
		this.breite = breite; 
		this.laenge = laenge; 
		this.hoehe = hoehe; 
	}

	public boolean isEineGroesse() {
		return eineGroesse;
	}

	public void setEineGroesse(boolean eineGroesse) {
		this.eineGroesse = eineGroesse;
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}	
}
