package com.newgig.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application implements Serializable {

	private String name;
	private List<String> dataSourceNames = new ArrayList<String>();

	public Application(String name) {
		this.name = name;
	}
	
	public void addDatasource(String name) {
		this.dataSourceNames.add(name);
	}

	public void removeDatasource(String name) {
		this.dataSourceNames.remove(name);
	}

	public Collection<String> list() {
		return this.dataSourceNames;
	}
	
	public String getName() {
		return name;
	}

}
