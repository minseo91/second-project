package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.ProductDTO;

public interface CartService {
	/**
	 * 장바구니 담기
	 * */
	public void cartInsert(CartDTO dto)throws SQLException;
		
	/**
	 * 수량 수정
	 * */
	public void cartUpdate(CartDTO dto)throws SQLException;
	
	/**
	 * 삭제
	 * */
	public void cartDelete(int cartNo)throws SQLException;
	
	/**
	 * 장바구니 주문  controller단에서 하면 될듯 orderservice불러와서 하면될듯
	 * */
	
	
	/**
	 * 장바구니 담은거 전체검색 
	 * */
	public List<CartDTO> selectAll(String id)throws SQLException;
	
	
	
	/**
	 * 장바구니 담은거 orders갈때 검색
	 * */
	public List<ProductDTO> cartOrders(String id)throws SQLException;
	
	
	public void cartOrderDelete(String id) throws SQLException ;
}
