package com.newgig.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.Environment;
import org.springframework.cloud.config.server.EnvironmentRepository;
import org.springframework.stereotype.Component;

import com.newgig.dao.mapdb.ApplicationDAOImpl;

@Component
public class MapDBCloudEnviromentRepository implements EnvironmentRepository {

	@Autowired
	private ApplicationDAOImpl applicationDatasourceDAO;

	@Override
	public Environment findOne(String aplicacao, String sufixo, String versao) {
		return null;
	}

}
