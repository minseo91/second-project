package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.CouponDTO;
import alcohol.mvc.util.DbUtil;

public class CouponDAOImpl implements CouponDAO {

	@Override
	public int couponInsert(CouponDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "";

		switch (dto.getcRate()) {
		case 3000:
			sql="insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon',?, 3000 ,sysdate, sysdate+30)";break;
		case 4000:
			sql="insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon',?, 4000 ,sysdate, sysdate+30)";break;
		case 5000:
			sql="insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon',?, 5000 ,sysdate, sysdate+30)"; 
			break;
		}
		
		
		try {
			con = DbUtil.getConnection();
			
			
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());	
			result = ps.executeUpdate();		
			
			
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int couponDelete(String id,String coupon) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM COUPON WHERE C_RATE=? AND U_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, coupon);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		System.out.println(result);
		return result;

	}

	@Override
	public List<CouponDTO> couponAll(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CouponDTO> list = new ArrayList<CouponDTO>();
		CouponDTO dto = null;
		String sql = "select * from coupon where U_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new CouponDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				list.add(dto);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
				
		return list;

	}

}
