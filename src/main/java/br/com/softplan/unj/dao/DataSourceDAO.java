package br.com.softplan.unj.dao;

import java.util.Collection;

import br.com.softplan.unj.model.DataSourceConnectionProperties;

public interface DataSourceDAO {

	void addDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);

	void editDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);

	void removeDataSource(String name);

	DataSourceConnectionProperties getDataSource(String name);

	Collection<DataSourceConnectionProperties> list();

}
