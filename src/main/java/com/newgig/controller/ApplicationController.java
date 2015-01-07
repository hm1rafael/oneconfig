package com.newgig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newgig.logic.ApplicationLogic;

@RestController
@RequestMapping("${oneconfig.application.controller.prefix:/app}")
public class ApplicationController {

	@Autowired
	private ApplicationLogic applicationLogic;
	
	@RequestMapping(value = "/{app}/addDatasources")
	public void addDatasource(@PathVariable("app") String applicationName, List<String> aliasNames) {
		this.applicationLogic.addDatasource(applicationName, aliasNames);
	}
	
}
