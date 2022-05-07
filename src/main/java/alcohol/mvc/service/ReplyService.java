package alcohol.mvc.service;

import java.sql.SQLException;

import alcohol.mvc.dto.ReplyDTO;

public interface ReplyService {

	/**
	 * 등록하기
	 * */
	public void replyInsert(ReplyDTO dto)throws SQLException;
	
	
	/**
	 * 수정하기
	 * */
	public void replyUpdate(ReplyDTO dto)throws SQLException;
	
	
	/**
	 * 삭제하기
	 * */
	public void replyDelete(String reNumber)throws SQLException;
	
	/**
	 * 출력?
	 * */
	public ReplyDTO replySelect(String qaNumber)throws SQLException;
}
