package br.com.softplan.unj.dao;

import java.util.Collection;

import br.com.softplan.unj.model.DataSourceConnectionProperties;

public interface DataSourceDAO {

	void addDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);
	
	void editDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties);

	void removeDatasource(String name);
	
	Collection<DataSourceConnectionProperties> list();
	
	
}
