package com.training.spring.contactsmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.contactsmanagementsystem.models.DummyModel;

@RestController
public class Hello {

	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	@RequestMapping(value = "/names", produces = "application/json", method = { RequestMethod.GET })
	public List<String> getNames() {
System.out.println("Hello--am starting");
		List<String> names = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			names.add("Name1akjkk" + i);
		}
		return names;

	}

	@RequestMapping(value = "/addname", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.POST })
	public DummyModel addNames(@RequestBody DummyModel dummyModel) {

		return dummyModel;

	}

	@RequestMapping(value = "/addnames", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.POST })
	public List<DummyModel> addNames1(@RequestBody List<DummyModel> dummyModel) {

		return dummyModel;

	}

}
