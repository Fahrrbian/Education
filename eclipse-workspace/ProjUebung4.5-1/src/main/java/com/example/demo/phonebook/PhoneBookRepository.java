package com.example.demo.phonebook;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBookEntry, Long> {
	Optional<PhoneBookEntry> findByName(String name); 

}
