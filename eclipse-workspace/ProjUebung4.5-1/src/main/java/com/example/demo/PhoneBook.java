package com.example.demo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.example.demo.phonebook.PhoneBookApp;

public class PhoneBook {
	   public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Phone Book Application");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(600, 400);

	            PhoneBookApp panel = new PhoneBookApp(); // UI-Komponenten in Panel-Klasse auslagern
	            frame.add(panel);

	            frame.setVisible(true);
	        });
	   }
}
