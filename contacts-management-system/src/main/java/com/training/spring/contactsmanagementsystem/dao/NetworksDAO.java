package com.training.spring.contactsmanagementsystem.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.spring.contactsmanagementsystem.entities.Networks;

public interface NetworksDAO extends CrudRepository<Networks, Integer> {

	public Networks getRecordsByNetworkName(String networkName);
	
	//typed quireis and native queries
	//select n.network_name from networks n where network_name = 'Vodafone' and network_iid=1

	@Query("select n.networkName from Networks n where n.networkName=:networkName")
	public Collection<String> getRecordsByNetworkNameUsingQueryAnnotation(@Param("networkName") String networkName);

	//selct * from y=====================
	@Query("select n from Networks n where n.networkName=:networkName")
	public Collection<Networks> getNetworksByNetworkNameUsingQueryAnnotation(@Param("networkName") String networkName);

	@Query("select n.networkName from Networks n where n.networkId=:networkId")
	public Collection<String> getRecordsByNetworkNameUsingQueryAnnotation(@Param("networkId") int networkId);

	int number = 1;

	@Query(value = "select n.network_Name from networks n where n.network_Id=" + number, nativeQuery = true)
	public Collection<String> getRecordsByNetworkNameUsingQueryAnnotation();

}
