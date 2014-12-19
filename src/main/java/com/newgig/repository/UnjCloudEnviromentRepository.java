package com.newgig.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.Environment;
import org.springframework.cloud.config.server.EnvironmentRepository;
import org.springframework.stereotype.Component;

import com.newgig.dao.mapdb.ApplicationDataSourceDAOImpl;

@Component
public class UnjCloudEnviromentRepository implements EnvironmentRepository {

	@Autowired
	private ApplicationDataSourceDAOImpl applicationDatasourceDAO;

	@Override
	public Environment findOne(String aplicacao, String sufixo, String versao) {
		return null;
	}

}
