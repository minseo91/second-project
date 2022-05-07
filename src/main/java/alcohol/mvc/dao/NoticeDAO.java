package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;

public interface NoticeDAO {

	/**
	 * 등록하기 INSERT INTO NOTICE VALUES(notice_no_seq.nextval,?,?,?,SYSDATE,0)
	 * */
	public int noticeInsert(NoticeDTO noticeDto)throws SQLException;
	
	/**
	 * 조회수 증가 기능 update NOTICE set VIEW_COUNT = VIEW_COUNT + 1 where NO_NUMBER=?
	 * */
	public int increamentByNoticeNum(int noNumber)throws SQLException;
	
	
	/**
	 * 삭제하기 DELECT FROM NOTICE WHERE NO_NUMBER=?
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 * */
	public int noticeDelete(int noNumber)throws SQLException;
	
	/**
	 * 수정하기 UPDATE NOTICE SET NO_TITLE=? ,NO_CONTENT=? WHERE NO_NUMBER=?
	 * @return : 1-수정성공 , 0 - 수정실패
	 * */
	public int noticeUpdate(NoticeDTO dto)throws SQLException;
	
	/**
	 * 전체검색 SELECT * FROM NOTICE
	 * */
	public List<NoticeDTO> noticeAll()throws SQLException;
	
	/**
	  * 레코드 전체 검색(페이지처리)
	  * */
	public List<NoticeDTO> getBoardList(int pageNo) throws SQLException;
 
	
	/**
	 * 상세검색 SELECT * FROM NOTICE WHERE NO_NUMBER=?
	 * */
	public NoticeDTO noticeSelect(int noNumber)throws SQLException;
	
	
	
}
