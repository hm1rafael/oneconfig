package com.newgig.dao.mapdb;

import java.util.Collection;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import com.newgig.dao.DataSourceDAO;
import com.newgig.model.DataSourceConnectionProperties;

@Repository
public class DataSourceDAOImpl implements DataSourceDAO {

	private static final String COLLECTION_NAME = "datasources";
	private MapDbHandler<DataSourceConnectionProperties> mapDbHandler = new MapDbHandler<DataSourceConnectionProperties>(COLLECTION_NAME);

	@PreDestroy
	private void closeDB() {
		this.mapDbHandler.close();
	}

	@Override
	public void addDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties) {
		this.mapDbHandler.insert(name, dataSourceConnectionProperties);
	}

	@Override
	public void editDataSource(String name, DataSourceConnectionProperties dataSourceConnectionProperties) {
		if (this.mapDbHandler.contains(name)) {
			addDataSource(name, dataSourceConnectionProperties);
		}
	}

	@Override
	public void removeDataSource(String name) {
		if (this.mapDbHandler.contains(name)) {
			this.mapDbHandler.remove(name);
		}
	}

	@Override
	public Collection<DataSourceConnectionProperties> list() {
		return this.mapDbHandler.list();
	}

	@Override
	public DataSourceConnectionProperties getDataSource(String name) {
		return this.mapDbHandler.getValue(name);
	}

}
