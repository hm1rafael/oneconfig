package br.com.softplan.unj.model;


public class DataSourceConnectionProperties {

	private String url;
	private String driver;
	private String user;
	private String password;
	
	private ConnectionPoolProperties specificConnectionPoolProperties = new ConnectionPoolProperties();
	
	public ConnectionPoolProperties getSpecificConnectionPoolProperties() {
		return this.specificConnectionPoolProperties;
	}
	
	public void setSpecificConnectionPoolProperties(ConnectionPoolProperties specificConnectionPoolProperties) {
		this.specificConnectionPoolProperties = specificConnectionPoolProperties;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
