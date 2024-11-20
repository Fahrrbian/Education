package de.uebung4_5.OnlineMGeschäft;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication(scanBasePackages = "de.uebung4_5.OnlineMGeschäft")
public class ModeApplication implements CommandLineRunner {
	
	@PersistenceContext
	private EntityManager entityManager; 
	

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		fillDatabase();		
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ModeApplication.class); 
		app.setAdditionalProfiles("modegeschaeft");
		app.run(args); 
		
		
	}
	
	
	private void fillDatabase() {
        // 1. Mitarbeiter erstellen
        Mitarbeiter mitarbeiter = new Mitarbeiter("jdoe", 17112024, "jdoe@example.com", "Doe", "John", "securepassword");
        
        // 2. Lieferant erstellen
        Lieferant lieferant = new Lieferant(1, "Hauptstraße", 12345, "Berlin", true);

        // 3. Accessoire erstellen
        Accessoire accessoire = new Accessoire(true, 20.0, 15.0, 5.0);
        accessoire.setBezeichnung("Stylischer Rucksack");
        accessoire.setStatus("Verfügbar");
        accessoire.setMarke("OutdoorPro");
        accessoire.setPreis(49.99);

        // 4. Schuhartikel erstellen
        Schuhartikel schuh = new Schuhartikel();
        schuh.setBezeichnung("Sportschuh");
        schuh.setStatus("Verfügbar");
        schuh.setMarke("Nike");
        schuh.setPreis(189.99);
        schuh.setSchuhart("Sneaker");
        schuh.setObermaterial("Leder");
        schuh.setInnenmaterial("Textil");
        schuh.setSohlenmaterial("Gummi");

        // 5. Beziehungen zwischen Objekten
        Set<Artikel> artikelListe = new HashSet<>();
        artikelListe.add(accessoire);
        artikelListe.add(schuh);

        mitarbeiter.setArtikel(artikelListe); // Mitarbeiter verwaltet Artikel
        lieferant.setArtikel(artikelListe);       // Lieferant liefert Artikel

        // Artikel-Objekte mit Lieferanten und Mitarbeitern verknüpfen
        accessoire.setLieferant(Set.of(lieferant));
        schuh.setLieferant(Set.of(lieferant));

        // Daten in der Datenbank speichern
        ;
        entityManager.persist(mitarbeiter);
        entityManager.persist(lieferant);
        entityManager.persist(accessoire);
        entityManager.persist(schuh);

        entityManager.flush();
    }

}
