package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.ReviewDTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public int reviewInsert(ReviewDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewDelete(int vNumber) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> reviewAll(int paging) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		String sql ="SELECT * FROM REVIEW";
		
		ReviewDTO dto = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();

			while(rs.next()) {
				dto = new ReviewDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
				list.add(dto);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}

	@Override
	public int reviewUpdate(ReviewDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> reviewSelect(String pName, int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		String sql ="select * from  (SELECT a.*, ROWNUM rnum FROM (select * from review where p_code =(select p_code from product where p_name = ?)) a) where  rnum>=? and rnum <=?";
		
		ReviewDTO dto = null;
		try {
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize()==0 ?totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전체페이지수 저장
			PageCnt.setPageNo(pageNo);
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pName);
			ps.setInt(2, (pageNo-1)*PageCnt.pagesize+1); //시작점
			ps.setInt(3, pageNo*PageCnt.pagesize); //끝점
			rs = ps.executeQuery();

			while(rs.next()) {
				dto = new ReviewDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
				list.add(dto);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}
	
	private int getTotalCount() throws SQLException{
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int totalCount = 0;
		String sql ="select count(*) from review";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount =rs.getInt(1);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return totalCount;
	}



	@Override
	public int avgReview(String pCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result = 0;
		//int check = this.checkReviewStar(pCode);
		//System.out.println(check+"확인");
		String sql ="SELECT * FROM(select p_code, ROUND(AVG(VIEW_SCORE),2) from REVIEW group by p_code) where p_code=?";
		//switch (check) {
		//case 0:
			//sql ="select p_code,view_score from product where p_code=?";			
			//break;
		//}


		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pCode);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				result = rs.getInt(2);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
	public int checkReviewStar(String pCode)throws SQLException{
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result = 0 ; 
		String sql ="select view_score from product where p_code=?";
		

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pCode);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				result = rs.getInt(2);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
		
	}
	
	

}
