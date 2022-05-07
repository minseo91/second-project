package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.FactoryDTO;

public interface FactoryDAO {

	/**
	 * 전체검색 SELECT * FROM FACTORY
	 * */
	public List<FactoryDTO> factoryAll()throws SQLException;
	
	
	/**
	 * 상세검색 SELECT * FROM FACTORY WHERE F_NAME=?
	 * */
	public FactoryDTO factorySelect(String name)throws SQLException;

}
