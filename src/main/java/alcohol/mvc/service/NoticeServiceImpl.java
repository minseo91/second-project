package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.NoticeDAO;
import alcohol.mvc.dao.NoticeDAOImpl;
import alcohol.mvc.dto.NoticeDTO;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO dao = new NoticeDAOImpl();
	
	@Override
	public void noticeInsert(NoticeDTO dto) throws SQLException {		
		int result = dao.noticeInsert(dto);
		
		//관리자가 로그인했는지 여부 체크 필요
		
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}


	@Override
	public void noticeDelete(int noNumber) throws SQLException {
		NoticeDTO notice = dao.noticeSelect(noNumber);
		
		//관리자가 로그인했는지 여부 체크 필요
		
		if(dao.noticeDelete(noNumber)==0) {
			throw new SQLException(noNumber+"번 게시물을 삭제할수 없습니다.");
		}
		
	}

	@Override
	public void noticeUpdate(NoticeDTO dto) throws SQLException {
		
		//관리자가 로그인했는지 여부 체크 필요
		int result= dao.noticeUpdate(dto);
		if(result==0) {
			throw new SQLException("수정되지 않았습니다.");
		}

	}

	@Override
	public List<NoticeDTO> noticeAll() throws SQLException {
		
		List<NoticeDTO> list = dao.noticeAll();
		
		return list;
	}
	
	

	@Override
	public List<NoticeDTO> noticeAll(int pageNo) throws SQLException {

		List<NoticeDTO> list = dao.getBoardList(pageNo);
		return list;
	}

	@Override
	public NoticeDTO noticeSelect(int noNumber , boolean flag) throws SQLException {
		
		if(flag) {//조회수증가
			if( dao.increamentByNoticeNum(noNumber)==0) { //조회수증가 실패!!
			   throw new SQLException("조회수 증가에 대한 오류가 발생하였습니다.");	
			}	
		}
		
		NoticeDTO notice = dao.noticeSelect(noNumber);
		if(notice==null) {
			throw new SQLException("상세보기에 오류가 발생했습니다..");
		}
		
		return notice;
	}

}
