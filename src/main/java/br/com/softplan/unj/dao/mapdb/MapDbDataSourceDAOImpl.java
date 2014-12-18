package br.com.softplan.unj.dao.mapdb;

import java.util.Collection;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import br.com.softplan.unj.dao.DataSourceDAO;
import br.com.softplan.unj.model.DataSourceConnectionProperties;

@Repository
public class MapDbDataSourceDAOImpl implements DataSourceDAO {

	private static final String COLLECTION_NAME = "datasources";
	private MapDbHandler<DataSourceConnectionProperties> mapDbHandler = new MapDbHandler<DataSourceConnectionProperties>(COLLECTION_NAME);
	
	@PreDestroy
	private void closeDB() {
		this.mapDbHandler.close();
	}

	@Override
	public void addDataSource(String name,	DataSourceConnectionProperties dataSourceConnectionProperties) {
		mapDbHandler.insert(name, dataSourceConnectionProperties);
	}

	@Override
	public void editDataSource(String name,
			DataSourceConnectionProperties dataSourceConnectionProperties) {
		if (mapDbHandler.contains(name)) {
			addDataSource(name, dataSourceConnectionProperties);
		}
		
	}

	@Override
	public void removeDatasource(String name) {
		if (mapDbHandler.contains(name)) {
			mapDbHandler.remove(name);
		}
	}

	@Override
	public Collection<DataSourceConnectionProperties> list() {
		return mapDbHandler.list();
	}
	
}

