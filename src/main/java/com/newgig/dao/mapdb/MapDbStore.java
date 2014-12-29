package com.newgig.dao.mapdb;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.hazelcast.core.MapStore;

public class MapDbStore<T> implements MapStore<String, T> {

	private static final String FILE_PREFIX = "_file";
	private Map<String, T> collection;
	private DB db;

	public MapDbStore(String collectionName) {
		this.db = DBMaker.newFileDB(new File(collectionName + FILE_PREFIX))
			.closeOnJvmShutdown()
			.make();
		this.collection = this.db.getHashMap(collectionName);
	}

	public void close() {
		this.db.close();
	}

	@Override
	public T load(String key) {
		return this.collection.get(key);
	}

	@Override
	public Map<String, T> loadAll(Collection<String> keys) {
		Map<String, T> returnedCollection = new ConcurrentHashMap<String, T>();
		for (String key : keys) returnedCollection.put(key, collection.get(key)); 
		return returnedCollection;
	}

	@Override
	public Set<String> loadAllKeys() {
		return this.collection.keySet();
	}

	@Override
	public void store(String key, T value) {
		this.collection.put(key, value);
	}

	@Override
	public void storeAll(Map<String, T> map) {
		this.collection.putAll(map);
		
	}

	@Override
	public void delete(String key) {
		this.collection.remove(key);
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		for (String key : keys) delete(key);
	}

}
