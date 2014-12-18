package br.com.softplan.unj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.unj.dao.mapdb.MapDbDataSourceDAOImpl;
import br.com.softplan.unj.model.ApplicationDatasources;

@RestController
@RequestMapping("${unj.oneconfig.prefix:/ds}")
public class DataSourceConfigurationController {

	@Autowired
	private MapDbDataSourceDAOImpl dataSourceDAO;
	
	@RequestMapping(value = "/add/{application/**}", method = RequestMethod.GET)
	public void add(@PathVariable("application") String applicationName) {
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void remove() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/list/{application}", method = RequestMethod.GET)
	public ApplicationDatasources list(@PathVariable("application")String applicationName) {
		return null;
	}
	
}
