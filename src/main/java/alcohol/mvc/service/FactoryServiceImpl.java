package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.FactoryDAO;
import alcohol.mvc.dao.FactoryDAOImpl;
import alcohol.mvc.dto.FactoryDTO;

public class FactoryServiceImpl implements FactoryService {
	
	private FactoryDAO dao = new FactoryDAOImpl();
	
	@Override
	public List<FactoryDTO> factoryAll() throws SQLException {
		List<FactoryDTO> list = dao.factoryAll();
		return list;
	}

	@Override
	public FactoryDTO factorySelect(String name) throws SQLException {
		FactoryDTO factory = dao.factorySelect(name);
		return factory;
	}

}
