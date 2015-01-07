package com.newgig.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionPoolProperties implements Serializable {
	
	private Map<String, String> connectionPoolProperties = new ConcurrentHashMap<String, String>();
	
	public void add(String connectionPoolProperty, String value) {
		this.connectionPoolProperties.put(connectionPoolProperty, value);
	}
	
	public void remove(String connectionPoolProperty) {
		if (this.connectionPoolProperties.containsKey(connectionPoolProperty)) this.connectionPoolProperties.remove(connectionPoolProperty);
		else throw new IllegalArgumentException("Invalid Key" + connectionPoolProperty);
	}
	
	public Collection<String> list() {
		return connectionPoolProperties.values();
	}
	
}
