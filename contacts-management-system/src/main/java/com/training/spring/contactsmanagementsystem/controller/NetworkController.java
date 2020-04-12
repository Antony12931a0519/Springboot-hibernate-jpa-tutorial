package com.training.spring.contactsmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.contactsmanagementsystem.entities.Networks;
import com.training.spring.contactsmanagementsystem.models.NetworksModel;
import com.training.spring.contactsmanagementsystem.service.NetworksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("networks")
@Api(value = "Contacts Management System", description = "Operations related to networks in the contacts management system")
public class NetworkController {
	// interface ref = class static method
	Logger log = LoggerFactory.getLogger(NetworkController.class);

	@Autowired
	NetworksService networksService;

	@RequestMapping(value = "/list", produces = "application/json", method = { RequestMethod.GET })
	@ApiOperation(value = "Operation to View the list of available networks in the system", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<NetworksModel> getNetworksList() {

		log.info("Starting of method");
		long t1 = System.currentTimeMillis();
		log.info("Execution Start time:" + t1);
		List<NetworksModel> list = networksService.getNetworksList();
		long t2 = System.currentTimeMillis();
		log.info("Execution end time:" + t2);
		log.info("ending  of method");
		log.info("Time taken to execute the method is :" + (t2 - t1));
		return list;

	}

	@RequestMapping(value = "/list/{netWorkName}", produces = "application/json", method = { RequestMethod.GET })
	public List<Networks> getNetworksList(
			@ApiParam(value = "Network name to search the list of related networks", required = true) @PathVariable("netWorkName") String networkName) {

		return networksService.getNetworksByNetworkNameUsingQueryAnnotation(networkName);

	}

	@RequestMapping(value = "/list/entity/manager", produces = "application/json", method = { RequestMethod.GET })
	public List<Networks> getNetworksByEntityManager() {

		return networksService.getNetworksUsingEntityManager();

	}

	@RequestMapping(value = "/list/entity/manager/1", produces = "application/json", method = { RequestMethod.GET })
	public List<Networks> getNetworksByEntityManager1() {

		return networksService.getNetworksUsingEntityManager1();

	}

	@RequestMapping(value = "/list/entity/manager/typed/query", produces = "application/json", method = {
			RequestMethod.GET })
	public List<Networks> getNetworksUsingEntityManagerUsingTypedQuery() {

		return networksService.getNetworksUsingEntityManagerUsingTypedQuery();

	}

	@RequestMapping(value = "/list/entity/manager/typed/query/1", produces = "application/json", method = {
			RequestMethod.GET })
	public List<String> getNetworksUsingEntityManagerUsingTypedQuery1() {

		return networksService.getNetworksUsingEntityManagerUsingTypedQuery1();

	}

	@RequestMapping(value = "/name", produces = "application/json", method = { RequestMethod.GET })
	public NetworksModel getNetworkByName() {

		return networksService.getNetworksByName("Vodafone", "");

	}

	@RequestMapping(value = "/name/{networkName}", produces = "application/json", method = { RequestMethod.GET })
	public List<String> getRecordsByNetworkNameUsingQueryAnnotation(@PathVariable("networkName") String networkName) {

		return networksService.getRecordsByNetworkNameUsingQueryAnnotation(networkName);

	}

	@RequestMapping(value = "/name/id/{networkId}", produces = "application/json", method = { RequestMethod.GET })
	public List<String> getRecordsByNetworkNameUsingQueryAnnotation(@PathVariable("networkId") int networkId) {

		return networksService.getRecordsByNetworkNameUsingQueryAnnotation(networkId);

	}

	@RequestMapping(value = "/name/id/1", produces = "application/json", method = { RequestMethod.GET })
	public List<String> getRecordsByNetworkNameUsingQueryAnnotation() {

		return networksService.getRecordsByNetworkNameUsingQueryAnnotation();

	}

	@RequestMapping(value = "/{networkName}", produces = "application/json", method = { RequestMethod.GET })
	public NetworksModel getNetworkBySpecifiedField(@PathVariable("networkName") String networkName) {

		return networksService.getNetworksByName(networkName, "");

	}

	@RequestMapping(value = "/field", produces = "application/json", method = { RequestMethod.GET })
	public NetworksModel getNetworkByField(@RequestParam("networkName") String networkName) {

		return networksService.getNetworksByName(networkName, "");

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

	@RequestMapping(value = "/delete", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.DELETE })
	public String deleteNetwork(@RequestBody NetworksModel networksModel) {

		return networksService.deleteNetwork(networksModel);

	}

}
