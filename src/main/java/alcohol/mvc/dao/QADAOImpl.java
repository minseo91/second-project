package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;
import alcohol.mvc.dto.QADTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.util.DbUtil;

public class QADAOImpl implements QADAO {

	@Override
	public int qaInsert(QADTO qaDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO QA VALUES(qa_no_seq.nextval,?,?,?,?,sysdate,?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, qaDTO.getUserId());
			ps.setInt(2, qaDTO.getQaCategory());
			ps.setString(3, qaDTO.getQaTitle());
			ps.setString(4, qaDTO.getQaContent());
			ps.setInt(5, qaDTO.getQaSecret());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public int qaDelete(int qaNumber) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM QA WHERE QA_NUMBER=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qaNumber);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int qaUpdate(QADTO qaDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE QA SET QA_CONTENT=? WHERE QA_NUMBER=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, qaDTO.getQaContent());
			ps.setInt(2, qaDTO.getQaNumber());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<QADTO> qaAll(int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QADTO> qaList = new ArrayList<QADTO>();

		String sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM QA ORDER BY QA_DATE desc) a) where  rnum>=? and rnum <=?";
		
		QADTO dto = null;
		try {
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize()==0 ?totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전체페이지수 저장
			PageCnt.setPageNo(pageNo);
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*PageCnt.pagesize+1); //시작점
			ps.setInt(2, pageNo*PageCnt.pagesize); //끝점
			
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new QADTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5),
						rs.getString(6));

				qaList.add(dto);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return qaList;
	}

	/**
	 * 전체 레코드 수 가져오기
	 */
	private int getTotalCount() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalCount = 0;
		String sql = "select count(*) from users";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return totalCount;
	}
	
	private int getTotalCount2(int categoryNum) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalCount = 0;
		String sql = "select count(*) from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM QA WHERE QA_CATEGORY =? ORDER BY QA_DATE desc) a)";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, categoryNum);
			rs = ps.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return totalCount;
	}
	
	

	@Override
	public QADTO qaSelect(int qaNumber) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QADTO qa = null;
		String sql = "SELECT * FROM QA WHERE QA_NUMBER=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qaNumber);

			rs = ps.executeQuery();
			if (rs.next()) {
				qa = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));

			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return qa;
	}

	@Override
	public List<QADTO> qaFilter(int categoryNum,int pageNo) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QADTO> qaList = new ArrayList<QADTO>();

		String sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM QA WHERE QA_CATEGORY =? ORDER BY QA_DATE desc) a) where  rnum>=? and rnum <=?";
		
		QADTO dto = null;
		try {
			int totalCount = this.getTotalCount2(categoryNum);
			int totalPage = totalCount%PageCnt.getPagesize()==0 ?totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전체페이지수 저장
			PageCnt.setPageNo(pageNo);
			System.out.println("totalpage = " + totalPage);
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, categoryNum);//카테고리 
			ps.setInt(2, (pageNo-1)*PageCnt.pagesize+1); //시작점
			ps.setInt(3, pageNo*PageCnt.pagesize); //끝점
			
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new QADTO(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7));
				
				qaList.add(dto);
			}
			
			
			System.out.println(qaList);
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		//System.out.println("dao " +qaList.get(0).getQaCategory());
		//System.out.println("dao " +qaList.get(0).getQaTitle());
		//System.out.println("dao " +qaList.get(0).getQaNumber());
		return qaList;
	}

}
