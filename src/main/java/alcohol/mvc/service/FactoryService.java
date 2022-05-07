package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.FactoryDTO;

public interface FactoryService {
	/**
	 * 전체검색 
	 * */
	public List<FactoryDTO> factoryAll()throws SQLException;
	
	
	/**
	 * 상세검색
	 * */
	public FactoryDTO factorySelect(String name)throws SQLException;

}
