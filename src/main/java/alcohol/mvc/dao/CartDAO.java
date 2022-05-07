package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.ProductDTO;

public interface CartDAO {
	/**
	 * 장바구니 담기 INSERT INTO CART VALUES(cart_no_seq.nextval,?,?,?)
	 * */
	public int cartInsert(CartDTO dto)throws SQLException;
	
	/**
	 * 수량 수정 UPDATE CART SET CART_COUNT =? WHERE CART_NUMBER=?
	 * */
	public int cartUpdate(CartDTO dto)throws SQLException;
	
	/**
	 * 삭제 DELETE FROM CART WHERE CART_NUMBER=?
	 * */
	public int cartDelete(int cartNo)throws SQLException;
	
	/**
	 * 장바구니 주문 (이건 서비스에서 하는건지 order에서 하는건지 모르겠다)
	 * */
	
	/**
	 * 장바구니 담은거 전체검색 SELECT * FROM CART
	 * */
	public List<CartDTO> selectAll(String id)throws SQLException;
	
	/**
	 * 장바구니 담은거 orders갈때 검색
	 * */
	public List<ProductDTO> cartOrders(String id)throws SQLException;
	
	public int cartOrderDelete(String id) throws SQLException;
}
