package com.training.spring.contactsmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.contactsmanagementsystem.models.ContactsModel;
import com.training.spring.contactsmanagementsystem.service.ContactsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/contacts")
public class ContactsController {
	Logger log = LoggerFactory.getLogger(ContactsController.class);
	
	

	@Autowired
	ContactsService contactsService;

	@RequestMapping(value = "/hello", produces = "application/json", method = { RequestMethod.GET })
	public String welcome() {
		
		return "Hello";
  
	}

	@RequestMapping(value = "/list", produces = "application/json", method = { RequestMethod.GET })
	public List<ContactsModel> getContactsList() {
		return contactsService.getContactsList();

	}

	@RequestMapping(value = "/deatils/{contactId}", produces = "application/json", method = { RequestMethod.GET })
	public ContactsModel getContactDetailsById(@PathVariable("contactId") int contactId) {
		return null;

	}

	@RequestMapping(value = "/details/add", produces = "application/json", consumes = "application/json", method = {
			RequestMethod.POST })
	public ResponseEntity<String> addContactDetails(@RequestBody ContactsModel contacts) {
		return new ResponseEntity<String>(contactsService.addContactDetails(contacts), HttpStatus.OK);

	}

	@RequestMapping(value = "/details/delete/{contactId}", produces = "application/json", method = {
			RequestMethod.DELETE })
	public String deleteContactDetails(@PathVariable("contactId") int contactId) {
		return contactsService.deleteContactDetails(contactId);

	}

	@RequestMapping(value = "/details/update", produces = "application/json", consumes = "application/json", method = {
			RequestMethod.PUT })
	public String updateContactDetails(@RequestBody ContactsModel contactsModel) {
		return contactsService.updateContactDetails(contactsModel);

	}
	
	@RequestMapping(value = "/list/patch", produces = "application/json", method = { RequestMethod.PATCH })
	public List<ContactsModel> getContactsList1() {
		return contactsService.getContactsList();

	}

}
