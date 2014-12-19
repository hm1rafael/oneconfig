package com.newgig.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newgig.logic.DataSourceLogic;
import com.newgig.model.ConnectionPoolProperties;
import com.newgig.model.DataSourceConnectionProperties;

@RestController
@RequestMapping("${unj.oneconfig.prefix:/ds}")
public class DataSourceConfigurationController {

	@Autowired
	private DataSourceLogic dataSourceLogic;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@PathVariable("application") String aliasName, DataSourceConnectionProperties dataSourceConnectionProperties) {
		this.dataSourceLogic.add(aliasName, dataSourceConnectionProperties);
	}

	@RequestMapping(value = "/addDefaultDsProperties")
	public void addDefaultConnectionProperties(DataSourceConnectionProperties dataSourceConnectionProperties) {
		this.dataSourceLogic.addDefaultDsConnectionProperties(dataSourceConnectionProperties);
	}

	@RequestMapping(value = "/addDefaultPoolProperties")
	public void addDefaultPoolProperties(ConnectionPoolProperties connectionPoolProperties) {
		this.dataSourceLogic.addDefaultPoolConnectionProperties(connectionPoolProperties);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void remove(String aliasName) {
		this.dataSourceLogic.remove(aliasName);
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Collection<DataSourceConnectionProperties> list() {
		return this.dataSourceLogic.list();
	}

}
