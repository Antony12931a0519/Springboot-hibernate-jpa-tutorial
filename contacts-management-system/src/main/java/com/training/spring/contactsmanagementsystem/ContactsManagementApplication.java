package com.training.spring.contactsmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins="*")
public class ContactsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsManagementApplication.class, args);  
	}

}
