package br.com.softplan.unj.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationDatasources {

	private List<String> dataSourceNames = new ArrayList<String>();

	public void addDataSource(String name) {
		this.dataSourceNames.add(name);
	}

	public void removeDataSource(String name) {
		this.dataSourceNames.remove(name);
	}

	public Collection<String> list() {
		return this.dataSourceNames;
	}

}
