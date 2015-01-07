package com.newgig.dao;

import java.util.Collection;

public interface ConfigDAO<T> {

	void add(String name, T value);

	void edit(String name, T value);

	void remove(String name);

	T get(String name);

	Collection<T> list();
	
}
