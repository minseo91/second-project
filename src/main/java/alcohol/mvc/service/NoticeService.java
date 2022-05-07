package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;

public interface NoticeService {
	/**
	 * 등록하기
	 * */
	public void noticeInsert(NoticeDTO dto)throws SQLException;
	
	/**
	 * 삭제하기
	 * */
	public void noticeDelete(int noNumber)throws SQLException;
	
	/**
	 * 수정하기
	 * */
	public void noticeUpdate(NoticeDTO dto)throws SQLException;
	
	/**
	 * 전체검색
	 * */
	public List<NoticeDTO> noticeAll()throws SQLException;
	
	/**
	 * paging처리
	 * */
    List<NoticeDTO> noticeAll(int pageNo) throws SQLException;
	
	/**
	 * 상세검색
	 * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	 * */
	public NoticeDTO noticeSelect(int noNumber, boolean flag)throws SQLException;
}
