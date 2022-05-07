package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.RefundDTO;

public interface RefundDAO {
	/**
	 * 환불하기(등록) INSERT INTO REFUND VALUES(?,orders_no_seq.currval,?,?)
	 * */
	public int refundInsert(RefundDTO dto)throws SQLException;
	
	/**
	 * 환불상태 변경(수정) UPDATE REFUND SET RE_STATUS=? WHERE RE_CODE=?
	 * */
	public int refundUpdate(RefundDTO dto)throws SQLException;
	
	
	/**
	 * 환불상태 표시(select)관리자 SELECT * FROM REFUND
	 * */
	public List<RefundDTO> refundAll()throws SQLException;
	
	/**
	 * 환불상태 표시(select)판매자가 보는 거 있어야 하나? 고민중 
	 * */
	
	
	
	
}
