package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.SubDTO;

public interface SubService {
	/**
	 * 구독하기(등록)
	 * */
	public void subInsert(SubDTO dto)throws SQLException;
	
	
	/**
	 * 구독취소(삭제)
	 * */
	public void subDelete(String sCode)throws SQLException;
	
	/**
	 * 구독리스트(아마도 관리자)
	 * */
	public List<SubDTO> subAll()throws SQLException;
	
	/**
	 * 구독상세(회원)
	 * */
	public SubDTO subSelect(String id)throws SQLException;
}
