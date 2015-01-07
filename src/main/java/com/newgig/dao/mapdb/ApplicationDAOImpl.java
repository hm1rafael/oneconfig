package com.newgig.dao.mapdb;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.newgig.dao.ConfigDAO;
import com.newgig.model.Application;

@Repository
public class ApplicationDAOImpl implements ConfigDAO<Application> {

	private static final String DATASOURCES = "application_datasources";
	private Map<String, Application> colecao;

	@PostConstruct
	public void create() {
		Config config = new Config();
		MapConfig mapConfig = config.getMapConfig(DATASOURCES);
		mapConfig.setMapStoreConfig(new MapStoreConfig().setImplementation(new MapDbStore<Application>(DATASOURCES)));
		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		this.colecao = instance.<String, Application> getMap(DATASOURCES);
	}
	
	@Override
	public void add(String name, Application value) {
		this.colecao.put(name, value);
	}

	@Override
	public void edit(String name, Application value) {
		add(name, value);
	}

	@Override
	public void remove(String key) {
		this.colecao.remove(key);
	}

	@Override
	public Application get(String key) {
		return this.colecao.get(key);
	}

	@Override
	public Collection<Application> list() {
		return this.colecao.values();
	}
	
	
}
