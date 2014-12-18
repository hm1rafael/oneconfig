package br.com.softplan.unj.dao.mapdb;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class MapDbHandler<T> {

	private static final String FILE_PREFIX = "_file";
	private Map<String, T> collection;
	private DB db;

	public MapDbHandler(String collectionName) {
		this.db = DBMaker.newFileDB(new File(collectionName + FILE_PREFIX))
			.closeOnJvmShutdown()
			.make();
		this.collection = this.db.getHashMap(collectionName);
	}

	public void insert(String key, T value) {
		this.collection.put(key, value);
		this.db.commit();
	}

	public void remove(String key) {
		this.collection.remove(key);
		this.db.commit();
	}

	public Collection<T> list() {
		return this.collection.values();
	}

	public T getValue(String key) {
		return this.collection.get(key);
	}

	public boolean contains(String name) {
		return this.collection.containsKey(name);
	}

	public void close() {
		this.db.close();
	}

}
