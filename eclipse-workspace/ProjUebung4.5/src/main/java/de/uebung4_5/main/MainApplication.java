package de.uebung4_5.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.uebung4_5.uni.Application;


@SpringBootApplication(scanBasePackages = "de.uebung4_5.uni")
public class MainApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args); 
	}
}
