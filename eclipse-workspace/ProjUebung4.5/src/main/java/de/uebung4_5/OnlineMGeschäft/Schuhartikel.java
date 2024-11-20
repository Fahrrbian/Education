package de.uebung4_5.OnlineMGeschäft;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//@DiscriminatorValue("SCHUHARTIKEL")
@Entity
public class Schuhartikel extends Artikel {

	
	private String schuhart; 
	private String obermaterial; 
	private String innenmaterial; 
	private String sohlenmaterial; 
	
	public Schuhartikel() {
		super(); 
	}
	public Schuhartikel(String schuhart, String innenmaterial, String obermaterial, String sohlenmaterial) {
		super(); 
		this.schuhart = schuhart; 
		this.innenmaterial = innenmaterial; 
		this.obermaterial = obermaterial; 
		this.sohlenmaterial = sohlenmaterial; 
	}
	public String getSchuhart() {
		return schuhart;
	}
	public void setSchuhart(String schuhart) {
		this.schuhart = schuhart;
	}
	public String getObermaterial() {
		return obermaterial;
	}
	public void setObermaterial(String obermaterial) {
		this.obermaterial = obermaterial;
	}
	public String getInnenmaterial() {
		return innenmaterial;
	}
	public void setInnenmaterial(String innenmaterial) {
		this.innenmaterial = innenmaterial;
	}
	public String getSohlenmaterial() {
		return sohlenmaterial;
	}
	public void setSohlenmaterial(String sohlenmaterial) {
		this.sohlenmaterial = sohlenmaterial;
	}
}
