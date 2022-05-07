package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.CouponDTO;

public interface CouponService {
	/**
	 * 등록
	 * */
	public void couponInsert(CouponDTO dto)throws SQLException;
	
	/**
	 * 사용(제거) 
	 * */
	public void couponDelete(String id,String coupon)throws SQLException;
	
	/**
	 * 쿠폰목록(select)
	 * */
	public List<CouponDTO> couponAll(String id)throws SQLException;
	

}
