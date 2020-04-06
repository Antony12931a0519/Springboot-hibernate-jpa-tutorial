package com.training.spring.contactsmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.spring.contactsmanagementsystem.dao.ContactsRepository;
import com.training.spring.contactsmanagementsystem.entities.Contacts;
import com.training.spring.contactsmanagementsystem.models.ContactsModel;

@Service
public class ContactsService {

	@Autowired
	ContactsRepository contactsRepository;

	public String addContactDetails(ContactsModel contacts) {

		String result = null;

		if (contacts != null) {
			Contacts contact = new Contacts();
			contact.setEmail(contacts.getEmail());
			contact.setFirstName(contacts.getFirstName());
			contact.setLastName(contacts.getLastName());
			contact.setMobile(contacts.getMobile());
			Contacts resultSet = contactsRepository.save(contact);
			if (resultSet != null) {
				result = "Contact Has Been Added Successfully.";
			}
		}
		return result;

	}

	public String updateContactDetails(ContactsModel contacts) {

		String result = null;

		if (contacts != null) {

			Optional<Contacts> resultSet = contactsRepository.findById(contacts.getContactId());
			Contacts contact = resultSet.get();
			if (contact != null) {

				String email = (contacts.getEmail() != null && !contacts.getEmail().isEmpty()) ? contacts.getEmail()
						: contact.getEmail();

				String lastName = (contacts.getLastName() != null && !contacts.getLastName().isEmpty())
						? contacts.getLastName()
						: contact.getLastName();

				String firstName = (contacts.getFirstName() != null && !contacts.getFirstName().isEmpty())
						? contacts.getFirstName()
						: contact.getFirstName();

				String mobile = (contacts.getMobile() != null && !contacts.getMobile().isEmpty()) ? contacts.getMobile()
						: contact.getMobile();

				contact.setEmail(email);
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setMobile(mobile);

				Contacts updatedContact = contactsRepository.save(contact);
				if (updatedContact != null) {
					result = "Contact Details Has Been Updated Successfully.";
				}
			}
		}
		return result;
	}

	public String deleteContactDetails(int contactId) {

		String result = null;

		if (contactId != 0) {

			try {

				Optional<Contacts> resultSet = contactsRepository.findById(contactId);
				Contacts contact = resultSet.get();
				if (contact != null) {
					contactsRepository.delete(contact);
					result = "Contact Details Has Been Deleted Successfully.";
				}
			} catch (Exception ex) {
				result = "Contact Details Failed To Delete .";
			}
		}
		return result;
	}

	 @Cacheable(cacheNames="contactsCache")
	public List<ContactsModel> getContactsList() {

		List<ContactsModel> contacts = null;
		List<Contacts> resultSet = contactsRepository.findAll();

		if (resultSet != null && resultSet.size() > 0) {
			contacts = new ArrayList<ContactsModel>();
			for (Contacts contact : resultSet) {

				ContactsModel contactModel = new ContactsModel();
				contactModel.setEmail(contact.getEmail());
				contactModel.setContactId(contact.getContactId());
				contactModel.setFirstName(contact.getFirstName());
				contactModel.setLastName(contact.getLastName());
				contactModel.setMobile(contact.getMobile());
				contacts.add(contactModel);
			}
			if (contacts != null && contacts.size() > 0)
				return contacts;
		}
		return contacts;
	}
}
