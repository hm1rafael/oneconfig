package br.com.softplan.unj.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.Environment;
import org.springframework.cloud.config.server.EnvironmentRepository;
import org.springframework.stereotype.Component;

import br.com.softplan.unj.dao.mapdb.MapDbDataSourceDAOImpl;

@Component
public class UnjCloudEnviromentRepository implements EnvironmentRepository {

	@Autowired
	private MapDbDataSourceDAOImpl datasourceDAO;
	
	public Environment findOne(String aplicacao, String sufixo, String versao) {
		return null;
	}

}
