package de.uebung4_5.OnlineMGeschäft;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "artikel_typ", discriminatorType = DiscriminatorType.STRING)
public abstract class Artikel {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long artikelnummer; 

	private String bezeichnung; 
	private String status; 
	private String marke;
	private double preis; 
	
	  @ManyToOne
	    @JoinColumn(name = "mitarbeiter_id", nullable = true) 
	    private Mitarbeiter mitarbeiter;
	  @ManyToMany(cascade = CascadeType.PERSIST)
	  @JoinTable(
		        name = "artikel_lieferanten", 
		        joinColumns = @JoinColumn(name = "artikel_id"), 
		        inverseJoinColumns = @JoinColumn(name = "lieferant_id") 
		    )
	private Set<Lieferant> lieferanten = new HashSet<>();
	
	public Artikel() {}
	
	
	public Artikel(String bezeichnung, Long artikelnummer, String status, String marke, double preis) {
		this.bezeichnung = bezeichnung; 
		this.artikelnummer = artikelnummer; 
		this.status = status; 
		this.marke = marke; 
		this.preis = preis; 
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Long getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(Long artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter; 
	}
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter; 
	}
	public Set<Lieferant> getLieferant() {
		return lieferanten;
	}
	public void setLieferant(Set<Lieferant> lieferanten) {
		this.lieferanten = lieferanten; 
	}
}
