package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.QADAO;
import alcohol.mvc.dao.QADAOImpl;
import alcohol.mvc.dto.QADTO;

public class QAServiceImpl implements QAService {
	
	private QADAO qaDao = new QADAOImpl();

	@Override
	public void qaInsert(QADTO qaDTO) throws SQLException {
		
		int result = qaDao.qaInsert(qaDTO);

		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void qaDelete(int qaNumber) throws SQLException {
		
		QADTO qa = qaDao.qaSelect(qaNumber);
		
		if(qaDao.qaDelete(qaNumber)==0) {
			throw new SQLException(qaNumber + "번 게시물을 삭제할 수 없습니다.");
		}
		

	}

	@Override
	public void qaUpdate(QADTO qaDTO) throws SQLException {
		
		int result = qaDao.qaUpdate(qaDTO);
		
		if(result==0) {
			throw new SQLException("수정되지 않았습니다.");
		}

	}

	@Override
	public List<QADTO> qaAll(int paging) throws SQLException {
		
		List<QADTO> list = qaDao.qaAll(paging);
		
		return list;
	}

	@Override
	public QADTO qaSelect(int qaNumber) throws SQLException {
		
		QADTO qa = qaDao.qaSelect(qaNumber);
		
		if(qa==null) {
			throw new SQLException("상세보기에 오류가 발생했습니다.");
		}
 		
		return qa;
	}

	@Override
	public List<QADTO> qaFilter(int categoryNum,int pageNo) throws SQLException{
		List<QADTO> list = qaDao.qaFilter(categoryNum,pageNo);
		return list;
	}

}
