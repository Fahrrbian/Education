package de.uebung4_5.uni;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DatabaseLoader {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Student> loadStudents() {
        // Alle Studenten aus der Datenbank abfragen
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Transactional
    public List<Vorlesung> loadVorlesungen() {
        // Alle Vorlesungen aus der Datenbank abfragen
        return entityManager.createQuery("SELECT v FROM Vorlesung v", Vorlesung.class).getResultList();
    }

    @Transactional
    public List<Professor> loadProfessors() {
        // Alle Professoren aus der Datenbank abfragen
        return entityManager.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
    }
}