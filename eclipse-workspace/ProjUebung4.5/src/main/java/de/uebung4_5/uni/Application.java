package de.uebung4_5.uni;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List; 


public class Application implements CommandLineRunner {

	@Autowired 
	DatabaseLoader loader = new DatabaseLoader();
	
	@PersistenceContext
	private EntityManager entityManager; 

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 
		List<Student> studentsloader = loader.loadStudents(); 
				
		Set<Vorlesung> vorlesungen = new HashSet<>();
		Set<Student> studenten= new HashSet<>(); 
		
		
		Adresse adresse= new Adresse(); 
		adresse.setStrasseHNr("Hauptstrasse");
		adresse.setPLZOrt("33129");
		
		Student student = new Student();
		student.setVorname("Max");
		student.setNachname("Mustermann");
		student.setAdresse(adresse);
		
		Professor professor = new Professor(); 
		professor.setName("Dr. Müller");
					
		Vorlesung vorlesung= new Vorlesung();
		vorlesung.setBeschreibung("Datenbanken");
		vorlesung.setName("Db1");
		vorlesung.setProf(professor);
		vorlesung.setStudenten(studenten);
		
		vorlesungen.add(vorlesung); 
		studenten.add(student); 
		
		professor.setVorlesungen(vorlesungen);
		
		entityManager.persist(vorlesung);
		entityManager.persist(professor);
		
		entityManager.flush();
		
		 System.out.println("Geladene Studenten:");
		    studentsloader.forEach(Student -> {
		        System.out.println("Name: " + Student.getVorname() + " " + Student.getNachname());
		        Student.getVorlesungen().forEach(v -> System.out.println("- " + v.getName()));
		    }); 
	}
}
