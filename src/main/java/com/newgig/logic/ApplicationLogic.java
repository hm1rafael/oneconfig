package com.newgig.logic;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newgig.dao.ConfigDAO;
import com.newgig.logic.annotation.Lock;
import com.newgig.model.Application;

@Service
public class ApplicationLogic {

	private ConfigDAO<Application> applicationDAO;
	private DataSourceLogic dataSourceLogic;
	
	@Lock
	public void add(String applicationName, List<String> aliasNames) {
		Application application = new Application(applicationName);
		for (String aliasName : aliasNames) {
			application.addDatasource(aliasName);
		}
		this.applicationDAO.add(applicationName, application);
	}
	
	@Lock
	public void remove(String applicationName) {
		this.applicationDAO.remove(applicationName);
	}
	
	public Collection<Application> list() {
		return applicationDAO.list();
	}

	@Lock
	public void addDatasource(String applicationName, List<String> aliasNames) {
		doDatasourceLogic("removeDatasource", applicationName, aliasNames);
	}

	@Lock
	public void removeDatasource(String applicationName, List<String> aliasNames) {
		doDatasourceLogic("addDatasource", applicationName, aliasNames);
	}
	
	private void doDatasourceLogic(String method, String applicationName, List<String> aliasNames) {
		Application application = getApplication(applicationName);
		for (String aliasName : aliasNames) {
			this.dataSourceLogic.verifyExisting(aliasName);
			executeMethod(method, application);
		}
		this.applicationDAO.edit(application.getName(), application);
	}

	private void executeMethod(String method, Application application) {
		try {
			application.getClass()
				.getMethod(method, String.class)
				.invoke(application);
		} catch (Exception e) {
			throw new IllegalStateException("Invalid state", e);
		}
	}

	private Application getApplication(String applicationName) {
		Application application = applicationDAO.get(applicationName);
		if (application == null) {
			throw new IllegalArgumentException("Application not found");
		}
		return application;
	}
	
}
