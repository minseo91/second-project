package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.NoticeDTO;
import alcohol.mvc.dto.SubDTO;
import alcohol.mvc.util.DbUtil;

public class SubDAOImpl implements SubDAO {

	@Override
	public int subInsert(SubDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "INSERT INTO SUBSCRIPTION VALUES('sub_' || subscription_no_seq.nextval,?,sysdate,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			System.out.println("dto.getUserId() = " + dto.getUserId());
			System.out.println("dto.getSubPrice() = " + dto.getSubPrice());
			ps.setString(1, dto.getUserId());
			ps.setInt(2, Integer.parseInt(dto.getSubPrice()));
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int subDelete(String sCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "DELETE FROM SUBSCRIPTION WHERE SUB_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sCode);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<SubDTO> subAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubDTO subSelect(String id) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		SubDTO dto=null;
		String sql = "SELECT * FROM SUBSCRIPTION WHERE U_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new SubDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

	@Override
	public SubDTO subSelectByCode(String sCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		SubDTO dto=null;
		String sql = "SELECT * FROM SUBSCRIPTION WHERE SUB_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sCode);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new SubDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dto;
	}

}
