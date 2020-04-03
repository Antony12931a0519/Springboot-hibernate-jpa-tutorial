package com.training.spring.contactsmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.contactsmanagementsystem.dao.NetworksDAO;
import com.training.spring.contactsmanagementsystem.entities.Networks;
import com.training.spring.contactsmanagementsystem.models.NetworksModel;

@Service
public class NetworksService {

	@Autowired
	NetworksDAO networksDAO;

	public List<NetworksModel> getNetworksList() {

		List<Networks> networks = (List<Networks>) networksDAO.findAll();

		List<NetworksModel> list = new ArrayList<NetworksModel>();
		for (Networks network : networks) {
			NetworksModel networksModel = new NetworksModel();
			networksModel.setNetworkId(network.getNetworkId());
			networksModel.setNetworkName(network.getNetworkName());

			list.add(networksModel);
		}
		return list;

	}

	public NetworksModel getNetworksByName(String networkName) {

		Networks networks = networksDAO.getRecordsByNetworkName(networkName);
		NetworksModel networksModel = new NetworksModel();
		networksModel.setNetworkId(networks.getNetworkId());
		networksModel.setNetworkName(networks.getNetworkName());
		return networksModel;

	}

}
