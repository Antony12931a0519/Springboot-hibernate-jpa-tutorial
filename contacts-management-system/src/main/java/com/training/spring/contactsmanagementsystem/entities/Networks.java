package com.training.spring.contactsmanagementsystem.entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "Networks")
@SqlResultSetMapping(name = "mapppinNativeQuery", // same as resultSetMapping
		// above in NativeQuery
		classes = {
				@ConstructorResult(targetClass = com.training.spring.contactsmanagementsystem.entities.Networks.class, columns = {
						@ColumnResult(name = "network_id", type = Integer.class),
						@ColumnResult(name = "network_name", type = String.class)
				}) })
@SqlResultSetMapping(name = "mapppinNativeQuery1", // same as resultSetMapping
// above in NativeQuery
classes = {
		@ConstructorResult(targetClass = com.training.spring.contactsmanagementsystem.entities.Networks.class, columns = {
				@ColumnResult(name = "network_name", type = String.class)
		}) })
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
	 * @param networkId
	 *            the networkId to set
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
	 * @param networkName
	 *            the networkName to set
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public Networks(int networkId, String networkName) {
		super();
		this.networkId = networkId;
		this.networkName = networkName;
		
		
	}

	public Networks() {

	}

	public Networks(String networkName) {
		super();
		this.networkName = networkName;
	}

}
