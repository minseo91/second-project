package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.OrdersDTO;

public interface PaymentDAO {
	/**
	 * 결재하기 select * from payment where pay_type=?
	 * */
	public int selectPay(int paytype,OrdersDTO oDTO,List<OrderLineDTO> oLineList)throws SQLException;
	
	
	public int onlySelectPay(int paytype,OrdersDTO oDTO,OrderLineDTO oLineDTO) throws SQLException;
}
