package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;


import alcohol.mvc.dao.SubDAO;
import alcohol.mvc.dao.SubDAOImpl;
import alcohol.mvc.dto.SubDTO;

public class SubServiceImpl implements SubService {

	private SubDAO dao = new SubDAOImpl();
	
	@Override
	public void subInsert(SubDTO dto) throws SQLException {
		
		int result = dao.subInsert(dto);
				
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void subDelete(String sCode) throws SQLException {
		
		SubDTO dto = dao.subSelectByCode(sCode);

	}

	@Override
	public List<SubDTO> subAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubDTO subSelect(String id) throws SQLException {
		
		SubDTO dto = dao.subSelect(id);
		
		return dto;
	}

}
