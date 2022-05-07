package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.RefundDTO;

public interface RefundService {
	/**
	 * 환불하기(등록) 
	 * */
	public void refundInsert(RefundDTO dto)throws SQLException;
	
	/**
	 * 환불상태 변경(수정)
	 * */
	public void refundUpdate(RefundDTO dto)throws SQLException;
	
	
	/**
	 * 환불상태 표시(select)관리자 
	 * */
	public List<RefundDTO> refundAll()throws SQLException;
	
	/**
	 * 환불상태 표시(select)판매자가 보는 거 있어야 하나? 고민중 
	 * */
}
