package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.OrderDAO;
import alcohol.mvc.dao.OrderDAOImpl;
import alcohol.mvc.dto.OrdersDTO;

public class OrderServiceImpl implements OrderService{

	private OrderDAO orderdao = new OrderDAOImpl();

	@Override
	public void orderInsert(List<OrdersDTO> list) throws SQLException {

		int result = orderdao.orderInsert(list);
	}

	@Override
	public void orderUpdate(OrdersDTO ordersDTO) throws SQLException {

		int result = orderdao.orderUpdate(ordersDTO);
		if(result ==0) throw new SQLException("주문이 수정되지 않았습니다.");
	}

	@Override
	public String orderStatus(int oCode) throws SQLException {

		String result = orderdao.orderStatus(oCode);

		return result;
	}

	@Override
	public void deliUpdate(OrdersDTO ordersDTO) throws SQLException {

		int result = orderdao.orderUpdate(ordersDTO);
		if(result ==0) throw new SQLException("배송상태가 수정되지 않았습니다.");
	}

	@Override
	public String deliStatus(int oCode) throws SQLException {

		String result = orderdao.deliStatus(oCode);

		return result;
	}

	@Override
	public List<OrdersDTO> orderAll(int pageNo) throws SQLException {
		
		List<OrdersDTO> list = orderdao.orderAll(pageNo);
		
		return list;
	}

}
