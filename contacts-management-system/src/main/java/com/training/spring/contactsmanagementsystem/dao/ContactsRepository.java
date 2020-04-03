package com.training.spring.contactsmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.contactsmanagementsystem.entities.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

}
