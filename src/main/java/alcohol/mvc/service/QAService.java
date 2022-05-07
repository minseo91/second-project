package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.QADTO;

public interface QAService {
	/**
	 * 등록하기 
	 * */
	public void qaInsert(QADTO qaDTO)throws SQLException;
	
	/**
	 * 삭제하기
	 * */
	public void qaDelete(int qaNumber)throws SQLException;
	
	/**
	 * 수정하기
	 * */
	public void qaUpdate(QADTO qaDTO)throws SQLException;
	
	/**
	 * 전체검색
	 * */
	public List<QADTO> qaAll(int paging)throws SQLException;
	
	/**
	 * 상세검색
	 * */
	public QADTO qaSelect(int qaNumber)throws SQLException;
	
	/**
	 * 페이징처리 , filter
	 * */
	public List<QADTO> qaFilter(int categoryNum,int pageNo) throws SQLException;
}
