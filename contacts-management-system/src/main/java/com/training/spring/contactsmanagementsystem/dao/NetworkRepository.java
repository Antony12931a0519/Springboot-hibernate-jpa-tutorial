package com.training.spring.contactsmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.training.spring.contactsmanagementsystem.entities.Networks;

@Repository
public class NetworkRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Networks> getNetworksUsingEntityManager() {

		Query query = entityManager.createNativeQuery("select * from networks", "mapppinNativeQuery");

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<Networks> getNetworksUsingEntityManagerUsingTypedQuery() {

		TypedQuery<Networks> query = (TypedQuery<Networks>) entityManager.createQuery("select n from Networks n");

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<String> getNetworksUsingEntityManagerUsingTypedQuery1() {

		TypedQuery<String> query = (TypedQuery<String>) entityManager.createQuery("select n.networkName from Networks n");

		return query.getResultList();

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Networks> getNetworksUsingEntityManager1() {

		Query query = entityManager.createNativeQuery("select n.network_name from networks n", "mapppinNativeQuery1");

		return query.getResultList();

	}

}
