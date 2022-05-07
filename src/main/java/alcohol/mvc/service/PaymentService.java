package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.OrdersDTO;

public interface PaymentService {
	/**
	 * 결재하기
	 * */
	public void selectPay(int paytype,OrdersDTO oDTO,List<OrderLineDTO> oLineList)throws SQLException;
	
	public void onlySelectPay(int paytype,OrdersDTO oDTO,OrderLineDTO oLineDTO) throws SQLException;
}
