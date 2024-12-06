package com.example.demo.phonebook;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PhoneBookEntryDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("phonebookPU");

    public void save(PhoneBookEntry entry) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entry);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<PhoneBookEntry> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM PhoneBookEntry e", PhoneBookEntry.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(PhoneBookEntry entry) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entry);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PhoneBookEntry entry = em.find(PhoneBookEntry.class, id);
            if (entry != null) {
                em.remove(entry);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}


