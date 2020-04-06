package com.training.spring.contactsmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.contactsmanagementsystem.models.NetworksModel;
import com.training.spring.contactsmanagementsystem.service.NetworksService;

@RestController
@RequestMapping("networks")
public class NetworkController {

	@Autowired
	NetworksService networksService;

	@RequestMapping(value = "/list", produces = "application/json", method = { RequestMethod.GET })
	public List<NetworksModel> getNetworksList() {

		return networksService.getNetworksList();

	}

	@RequestMapping(value = "/name", produces = "application/json", method = { RequestMethod.GET })
	public NetworksModel getNetworkByName() {

		return networksService.getNetworksByName("Vodafone");

	}

	@RequestMapping(value = "/add", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.POST })
	public String addNetwork(@RequestBody NetworksModel networksModel) {

		return networksService.addNetwork(networksModel);

	}

	@RequestMapping(value = "/add/list", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.POST })
	public String addNetworks(@RequestBody List<NetworksModel> networksModels) {

		return networksService.addNetworks(networksModels);

	}
	
	@RequestMapping(value = "/update", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.PUT })
	public String updateNetwork(@RequestBody NetworksModel networksModel) {

		return networksService.updateNetwork(networksModel);

	}

}
