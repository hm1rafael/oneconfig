package br.com.softplan.unj.model;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDatasources {

	private List<String> dataSourceNames = new ArrayList<String>();
	
	private ConnectionPoolProperties defaultConnectionPoolProperties = new ConnectionPoolProperties();

	public ConnectionPoolProperties getDefaultConnectionPoolProperties() {
		return this.defaultConnectionPoolProperties;
	}
	
	public void setDefaultConnectionPoolProperties(ConnectionPoolProperties defaultConnectionPoolProperties) {
		this.defaultConnectionPoolProperties = defaultConnectionPoolProperties;
	}
	
	public void addDataSource(String name) {
		this.dataSourceNames.add(name);
	}
	
	public void removeDataSource(String name) {
		this.dataSourceNames.remove(name);
	}
	
}
