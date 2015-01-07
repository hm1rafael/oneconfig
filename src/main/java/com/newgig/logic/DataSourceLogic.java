package com.newgig.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgig.dao.ConfigDAO;
import com.newgig.handler.MergePropertyHandler; 
import com.newgig.model.ConnectionPoolProperties;
import com.newgig.model.DatasourceConnectionProperties;

@Service
public class DataSourceLogic {

	private static final String DEFAULT = "default";

	@Autowired
	private ConfigDAO<DatasourceConnectionProperties> dataSourceDAO;
	private MergePropertyHandler mergePropertyHandler;

	public void addDefaultDsConnectionProperties(DatasourceConnectionProperties dataSourceConnectionProperties) {
		this.dataSourceDAO.add(DEFAULT, dataSourceConnectionProperties);
	}

	public void addDefaultPoolConnectionProperties(ConnectionPoolProperties connectionPoolProperties) {
		DatasourceConnectionProperties dataSourceConnectionProperties = getDefaultDataSourceConnectionProperties();
		if (dataSourceConnectionProperties == null) {
			dataSourceConnectionProperties = new DatasourceConnectionProperties();
		}
		dataSourceConnectionProperties.setSpecificConnectionPoolProperties(connectionPoolProperties);
		this.dataSourceDAO.add(DEFAULT, dataSourceConnectionProperties);
	} 

	public Collection<DatasourceConnectionProperties> list() {
		return this.dataSourceDAO.list();
	}

	public void add(String aliasName, DatasourceConnectionProperties dataSourceConnectionProperties) {
		overrideWithDefaultValues(dataSourceConnectionProperties);
		this.dataSourceDAO.add(aliasName, dataSourceConnectionProperties);
	}

	private void overrideWithDefaultValues(DatasourceConnectionProperties dataSourceConnectionProperties) {
		DatasourceConnectionProperties dataSourceConnectionPropertiesDefault = getDefaultDataSourceConnectionProperties();
		if (dataSourceConnectionPropertiesDefault == null) {
			return;
		}
		this.mergePropertyHandler.copyIfNull(dataSourceConnectionPropertiesDefault, dataSourceConnectionProperties);
	}

	private DatasourceConnectionProperties getDefaultDataSourceConnectionProperties() {
		return this.dataSourceDAO.get(DEFAULT);
	}

	public void remove(String aliasName) {
		this.dataSourceDAO.remove(aliasName);
	}
	
	public DatasourceConnectionProperties find(String aliasName) {
		return this.dataSourceDAO.get(aliasName);
	}

	public void verifyExisting(String aliasName) {
		DatasourceConnectionProperties ds = find(aliasName);
		if (ds == null) {
			throw new IllegalArgumentException("No existing datasource");
		}
	}

}
