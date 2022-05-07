package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.util.DbUtil;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public int noticeInsert(NoticeDTO noticeDto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "INSERT INTO NOTICE VALUES(notice_no_seq.nextval,?,?,?,SYSDATE,0)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, noticeDto.getUserId());
			ps.setString(2, noticeDto.getNoTitle());
			ps.setString(3, noticeDto.getNoContent());
			
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int increamentByNoticeNum(int noNumber) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "update NOTICE set VIEW_COUNT = VIEW_COUNT + 1 where NO_NUMBER=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, noNumber);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int noticeDelete(int noNumber) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "DELETE FROM NOTICE WHERE NO_NUMBER=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, noNumber);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int noticeUpdate(NoticeDTO noticeDto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "UPDATE NOTICE SET NO_TITLE=? ,NO_CONTENT=?,NO_DATE =? WHERE NO_NUMBER=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, noticeDto.getNoTitle());
			ps.setString(2, noticeDto.getNoContent());
			ps.setString(3, noticeDto.getNoDate());
			ps.setInt(4, noticeDto.getNoNumber());
					
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		System.out.println(result);
		return result;
	}

	@Override
	public List<NoticeDTO> noticeAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		String sql = "SELECT * FROM NOTICE order by no_number";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						               rs.getString(4), rs.getString(5), rs.getInt(6));
				
				noticeList.add(notice);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return noticeList;
	}
	
	
	@Override
	public List<NoticeDTO> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		String sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM notice ORDER BY no_number) a) where  rnum>=? and rnum <=? ";
	
		try {
			//전체레코드 수를 구해서 총페이지수를 구하고 db에서 꺼내 올 게시물의 개수를 pagesize만큼 가져온다.(시작 ~ 끝)
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize() ==0 ? totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전체페이지수를 저장해준다.
			pageCnt.setPageNo(pageNo); //사용자가 클릭한 page번호를 설정
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 2개의 값 설정
			ps.setInt(1, (pageNo-1)*PageCnt.pagesize+1); //시작점번호
			ps.setInt(2, pageNo*PageCnt.pagesize); //끝점 번호 
			
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						               rs.getString(4), rs.getString(5), rs.getInt(6));
				
				noticeList.add(notice);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return noticeList;
	}
	
	/**
	 * 전체레코드수 가져오기 
	 * */
	private int getTotalCount() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalCount=0;
		String sql = "select count(*) from notice";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return totalCount;
	}
	

	@Override
	public NoticeDTO noticeSelect(int noNumber) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		NoticeDTO notice=null;
		String sql = "SELECT * FROM NOTICE WHERE NO_NUMBER=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, noNumber);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				notice = new NoticeDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						               rs.getString(4), rs.getString(5), rs.getInt(6));
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return notice;
	}

}
