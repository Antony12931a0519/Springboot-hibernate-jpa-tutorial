package com.training.spring.contactsmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.spring.contactsmanagementsystem.entities.Networks;

public interface NetworksDAO extends CrudRepository<Networks,Integer >{
	
	public Networks getRecordsByNetworkName(String networkName);
	

}
