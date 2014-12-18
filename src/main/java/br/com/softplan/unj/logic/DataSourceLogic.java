package br.com.softplan.unj.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.unj.dao.DataSourceDAO;
import br.com.softplan.unj.handler.MergePropertyHandler;
import br.com.softplan.unj.model.ConnectionPoolProperties;
import br.com.softplan.unj.model.DataSourceConnectionProperties;

@Service
public class DataSourceLogic {

	private static final String DEFAULT = "default";

	@Autowired
	private DataSourceDAO dataSourceDAO;
	private MergePropertyHandler mergePropertyHandler;

	public void addDefaultDsConnectionProperties(DataSourceConnectionProperties dataSourceConnectionProperties) {
		this.dataSourceDAO.addDataSource(DEFAULT, dataSourceConnectionProperties);
	}

	public void addDefaultPoolConnectionProperties(ConnectionPoolProperties connectionPoolProperties) {
		DataSourceConnectionProperties dataSourceConnectionProperties = getDefaultDataSourceConnectionProperties();
		if (dataSourceConnectionProperties == null) {
			dataSourceConnectionProperties = new DataSourceConnectionProperties();
		}
		dataSourceConnectionProperties.setSpecificConnectionPoolProperties(connectionPoolProperties);
		this.dataSourceDAO.addDataSource(DEFAULT, dataSourceConnectionProperties);
	}

	public Collection<DataSourceConnectionProperties> list() {
		return this.dataSourceDAO.list();
	}

	public void add(String aliasName, DataSourceConnectionProperties dataSourceConnectionProperties) {
		overrideWithDefaultValues(dataSourceConnectionProperties);
		this.dataSourceDAO.addDataSource(aliasName, dataSourceConnectionProperties);
	}

	private void overrideWithDefaultValues(DataSourceConnectionProperties dataSourceConnectionProperties) {
		DataSourceConnectionProperties dataSourceConnectionPropertiesDefault = getDefaultDataSourceConnectionProperties();
		if (dataSourceConnectionPropertiesDefault == null) {
			return;
		}
		this.mergePropertyHandler.copyIfNull(dataSourceConnectionPropertiesDefault, dataSourceConnectionProperties);
	}

	private DataSourceConnectionProperties getDefaultDataSourceConnectionProperties() {
		return this.dataSourceDAO.getDataSource(DEFAULT);
	}

	public void remove(String aliasName) {
		this.dataSourceDAO.removeDataSource(aliasName);
	}

}