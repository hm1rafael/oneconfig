package com.newgig.dao;

import java.util.Collection;

import com.newgig.model.DataSourceConnectionProperties;

public interface DataSourceDAO {

	void addDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);

	void editDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);

	void removeDataSource(String name);

	DataSourceConnectionProperties getDataSource(String name);

	Collection<DataSourceConnectionProperties> list();

}
