package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.CouponDAO;
import alcohol.mvc.dao.CouponDAOImpl;
import alcohol.mvc.dto.CouponDTO;

public class CouponServiceImpl implements CouponService {
	private CouponDAO dao = new CouponDAOImpl();
	@Override
	public void couponInsert(CouponDTO dto) throws SQLException {
		dao.couponInsert(dto);

	}

	@Override
	public void couponDelete(String id,String coupon) throws SQLException {
		int result =dao.couponDelete(id, coupon);
		if(result == 0) {
			throw new  SQLException("쿠폰삭제되지않음");
		}
	}

	@Override
	public List<CouponDTO> couponAll(String id) throws SQLException {
		List<CouponDTO> list = dao.couponAll(id);
		return list;
	}

}
