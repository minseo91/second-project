package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.SubDTO;

public interface SubDAO {

	/**
	 * 구독하기(등록) INSERT INTO SUBSCRIPTION VALUES('sub_' || subscription_no_seq.nextval,?,sysdate,?)
	 * */
	public int subInsert(SubDTO dto)throws SQLException;
	
	
	/**
	 * 구독취소(삭제) DELETE FROM SUBSCRIPTION WHERE SUB_CODE=?
	 * */
	public int subDelete(String sCode)throws SQLException;
	
	/**
	 * 구독 .. SELECT * FROM SUBSCRIPTION WHERE SUB_CODE=?
	 * */
	public SubDTO subSelectByCode(String sCode)throws SQLException;
	
	/**
	 * 구독리스트(아마도 관리자) SELECT * FROM SUBSCRIPTION
	 * */
	public List<SubDTO> subAll()throws SQLException;
	
	/**
	 * 구독상세(회원) SELECT * FROM SUBSCRIPTION WHERE U_ID=?
	 * */
	public SubDTO subSelect(String id)throws SQLException;
}
