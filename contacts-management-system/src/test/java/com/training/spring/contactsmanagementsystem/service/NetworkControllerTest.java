package com.training.spring.contactsmanagementsystem.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.spring.contactsmanagementsystem.dao.NetworksDAO;
import com.training.spring.contactsmanagementsystem.entities.Networks;
import com.training.spring.contactsmanagementsystem.models.NetworksModel;

@RunWith(SpringRunner.class)
public class NetworkControllerTest {

	@InjectMocks
	NetworksService networksService;

	@Mock
	NetworksDAO networksDAO;

	@Test
	public void testNetworksListForSuccess() {
		List<Networks> list = new ArrayList<>();
		list.add(new Networks(1, "fl"));
		Mockito.when(networksDAO.findAll()).thenReturn(list);
		List<NetworksModel> result = networksService.getNetworksList();
		assertNotNull(result);
	}

}
