package com.example.demo.OnlineMG;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



//@DiscriminatorValue("KLEIDUNGSARTIKEL")
@Entity
public class Kleidungsartikel extends Artikel{
	
	private String material; 
	
	public Kleidungsartikel() {
		super(); 
	}
	
	public Kleidungsartikel(String material) {
        super(); 
        this.material = material;
    }

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}
