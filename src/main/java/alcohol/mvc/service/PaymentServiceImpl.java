package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.PaymentDAO;
import alcohol.mvc.dao.PaymentDAOImpl;
import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.OrdersDTO;

public class PaymentServiceImpl implements PaymentService {
	private PaymentDAO dao = new PaymentDAOImpl();
	@Override
	public void selectPay(int paytype,OrdersDTO oDTO,List<OrderLineDTO> oLineList) throws SQLException {
		int result = dao.selectPay(paytype,oDTO,oLineList);
		if(result==0) {
			throw new SQLException("결재방식 등록안됨");
		}
	}
	@Override
	public void onlySelectPay(int paytype, OrdersDTO oDTO, OrderLineDTO oLineDTO) throws SQLException {
		dao.onlySelectPay(paytype, oDTO, oLineDTO);
		
	}
	
	
	

}
