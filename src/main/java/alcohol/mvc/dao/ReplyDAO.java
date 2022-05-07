package alcohol.mvc.dao;

import java.sql.SQLException;

import alcohol.mvc.dto.ReplyDTO;

public interface ReplyDAO {

	/**
	 * 등록하기 INSERT INTO REPLY VALUES(reply_no_seq.nextval,?,?,?,SYSDATE,?)
	 * */
	public int replyInsert(ReplyDTO dto)throws SQLException;
	
	
	/**
	 * 수정하기 UPDATE REPLY SET RE_CONTENT =? WHERE RE_NUMBER=?
	 * */
	public int replyUpdate(ReplyDTO dto)throws SQLException;
	
	
	/**
	 * 삭제하기 DELETE FROM REPLY WHERE RE_NUMBER=?
	 * */
	public int replyDelete(String reNumber)throws SQLException;
	
	/**
	 * 출력? SELECT * FROM REPLY WHERE QA_NUMBER=?
	 * */
	public ReplyDTO replySelect(String qaNumber)throws SQLException;
}
