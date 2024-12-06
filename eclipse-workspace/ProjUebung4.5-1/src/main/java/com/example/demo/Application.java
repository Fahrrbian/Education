package com.example.demo;



import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.phonebook.PhoneBookApp;
import com.example.demo.phonebook.PhoneBookEntry;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

	        SwingUtilities.invokeLater(() -> {
	            PhoneBookApp app = context.getBean(PhoneBookApp.class);
	            app.setVisible(true);
	        });
	}

}
