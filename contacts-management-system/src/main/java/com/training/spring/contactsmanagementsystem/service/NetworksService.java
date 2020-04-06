package com.training.spring.contactsmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		
		try {
			Networks networks = networksDAO.getRecordsByNetworkName(networkName);
			NetworksModel networksModel = new NetworksModel();
			networksModel.setNetworkId(networks.getNetworkId());
			networksModel.setNetworkName(networks.getNetworkName());
			return networksModel;
			
		}catch(Exception ec) {
			System.out.println(ec);
		}
		return null;

		

	}

	public String addNetwork(NetworksModel networksModel) {

		String result = null;

		if (networksModel != null) {

			Networks network = null;

			network = networksDAO.getRecordsByNetworkName(networksModel.getNetworkName());

			if (network != null) {

				result = network.getNetworkName() + " is already available";

			} else {
				network = new Networks();
				network.setNetworkName(networksModel.getNetworkName());
				network = networksDAO.save(network);
				result = network.getNetworkName() + " is added successfully.";
			}

		}
		return result;

	}

	public String addNetworks(List<NetworksModel> networksModels) {

		String result = null;

		List<Networks> networks = new ArrayList<>();

		for (NetworksModel n : networksModels) {

			Networks network = new Networks();
			network.setNetworkName(n.getNetworkName());
			networks.add(network);

		}

		networks = (List<Networks>) networksDAO.saveAll(networks);

		if (networks != null && networks.size() > 0) {
			result = "networks added successfully";
			return result;
		}
		return "Failed to add the networks";

	}

	public String updateNetwork(NetworksModel networksModel) {

		String result = null;

		if (networksModel.getNetworkId() != 0) {

			Networks network = null;

			Optional<Networks> networkOptional = networksDAO.findById(networksModel.getNetworkId());
			network = networkOptional.get();

			if (network != null) {

				if (networksModel.getNetworkName() != null && !networksModel.getNetworkName().isEmpty()) {
					network.setNetworkName(networksModel.getNetworkName());
				} else {
					network.setNetworkName(network.getNetworkName());
				}
				network = networksDAO.save(network);
				if (network != null) {
					result = network.getNetworkName() + " is updated ";
				}else {
					result = networksModel.getNetworkName() + "is not updated";
				}

				

			}
		}
		return result;
	}

}
