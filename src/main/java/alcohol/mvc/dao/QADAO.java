package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;
import alcohol.mvc.dto.QADTO;

public interface QADAO {
	/**
	 * 등록하기 INSERT INTO NOTICE VALUES(qa_no_seq.nextval,?,?,?,?,sysdate,?)
	 * */
	public int qaInsert(QADTO qaDTO)throws SQLException;
	
	/**
	 * 삭제하기 DELECT FROM QA WHERE QA_NUMBER=?
	 * */
	public int qaDelete(int qaNumber)throws SQLException;
	
	/**
	 * 수정하기 UPDATE QA SET QA_CONTENT=? WHERE QA_NUMBER=?
	 * */
	public int qaUpdate(QADTO qaDTO)throws SQLException;
	
	/**
	 * 전체검색 SELECT * FROM QA
	 * */
	public List<QADTO> qaAll(int paging)throws SQLException;
	
	/**
	 * 상세검색 SELECT * FROM QA WHERE QA_NUMBER=?
	 * */
	public QADTO qaSelect(int qaNumber)throws SQLException;
	

	/**
	 * 조건검색(검색필드와 검색단어를 전달받아 검색필드에 검색단어를포함한 레코드를 검색하기 )
	 *   SELECT * FROM QA WHERE QA_CATEGORY = ?
	 *  step 14 dbcp dao처럼
	 * */
	public List<QADTO> qaFilter(int categoryNum,int pageNo) throws SQLException;
	

}
