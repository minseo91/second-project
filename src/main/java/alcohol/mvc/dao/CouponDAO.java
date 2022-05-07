package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.CouponDTO;

public interface CouponDAO {

	/**
	 * 등록 INSERT INTO COUPON VALUES(?,?,?,?,SYSDATE,SYSDATE+30)
	 * */
	public int couponInsert(CouponDTO dto)throws SQLException;
	
	/**
	 * 사용(제거) DELECT FROM COUPON WHERE C_NUMBER =?
	 * */
	public int couponDelete(String id,String coupon)throws SQLException;
	
	/**
	 * 쿠폰목록(select) select * from coupon where U_ID=?
	 * */
	public List<CouponDTO> couponAll(String id)throws SQLException;
	

	
}
