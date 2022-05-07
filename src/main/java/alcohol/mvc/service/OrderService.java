package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.OrdersDTO;

public interface OrderService {
	/**
	 * 주문하기(등록) 
	 * */
	public void orderInsert(List<OrdersDTO> list)throws SQLException;
	
	
	/**
	 * 주문 상태수정
	 * */
	public void orderUpdate(OrdersDTO ordersDTO)throws SQLException;
	
	/**
	 * 주문 상태출력
	 * */
	public String orderStatus(int oCode)throws SQLException;
	
	/**
	 * 배송 상태 수정
	 * */
	public void deliUpdate(OrdersDTO ordersDTO)throws SQLException;
	
	/**
	 * 배송 상태 출력
	 * */
	public String deliStatus(int oCode)throws SQLException;

	/**
	 * 배송관리 테이블 전체 출력
	 */
	public List<OrdersDTO> orderAll(int pageNo) throws SQLException; 
}
