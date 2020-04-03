package com.training.spring.contactsmanagementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Networks")
public class Networks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "network_id")
	private int networkId;
	@Column(name = "network_name")
	private String networkName;
	/**
	 * @return the networkId
	 */
	public int getNetworkId() {
		return networkId;
	}
	/**
	 * @param networkId the networkId to set
	 */
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}
	/**
	 * @return the networkName
	 */
	public String getNetworkName() {
		return networkName;
	}
	/**
	 * @param networkName the networkName to set
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

}
