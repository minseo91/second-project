package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.OrdersDTO;
import alcohol.mvc.util.DbUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public int selectPay(int paytype,OrdersDTO oDTO,List<OrderLineDTO> oLineList) throws SQLException {
		Connection con= null;
		PreparedStatement ps = null;
		String sql = "";
		int result =0;
		int orderResult = 0;
		switch (paytype) {
		case 0:		
			sql= "insert into payment values(payment_no_seq.nextval, 1, '우리은행 1111-111-111111')";
			
			break;

		default:
			sql= "insert into payment values(payment_no_seq.nextval, default, null)";
			break;
		}
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps= con.prepareStatement(sql);
			
			
			result = ps.executeUpdate();
			
			orderResult=orderInsert(con,oDTO);
			
			

			 if(orderResult==0) {
				   con.rollback();
				   throw new SQLException("주문 실패...");
			   }
			   else {
				  int re [] = orderLineInsert(con, oLineList); //주문상세 등록하기 
				   for(int i : re) {
					   if(i != 1) {//
						   con.rollback();
						   throw new SQLException("주문 할수 없습니다....");
					   }
				   }
			
			   }
			
			
		} finally {
			con.commit();
			DbUtil.dbClose(null, ps, con);
			
		}
		
		
		return result;
	}
	
	
	public int  orderInsert(Connection con,OrdersDTO oDTO)  throws SQLException{
		PreparedStatement ps= null;
		String sql = "insert into orders values(orders_no_seq.nextval,?,payment_no_seq.currval,sysdate,'결제완료','배송대기중',?,?,?)";
		int result  =0;
		
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, oDTO.getuId());
			ps.setString(2, oDTO.getDeliAddr());
			ps.setString(3, oDTO.getDeliAddr2());
			ps.setString(4, oDTO.getOrderPhone());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(null, ps,null);
			
		}

		return result;
	}
	
	
	public int[] orderLineInsert(Connection con,List<OrderLineDTO> oLineList)throws SQLException {
		PreparedStatement ps= null;
		String sql = "insert into order_line values(order_line_no_seq.nextval,orders_no_seq.currval,?,?)";
		int result []= null;
		try {
			ps= con.prepareStatement(sql);
			
			for (OrderLineDTO dto : oLineList) {
				ps.setString(1, dto.getpCode());
				ps.setInt(2, dto.getOrderLineCount());
				
				ps.addBatch();
				ps.clearParameters();
				
			}
			result=ps.executeBatch();
	
			
		} finally {
			DbUtil.dbClose(null, ps,null);
		}
		
		return result;
	}


	@Override
	public int onlySelectPay(int paytype, OrdersDTO oDTO, OrderLineDTO oLineDTO) throws SQLException {
		Connection con= null;
		PreparedStatement ps = null;
		String sql = "";
		int result =0;
		int orderResult = 0;
		switch (paytype) {
		case 0:		
			sql= "insert into payment values(payment_no_seq.nextval, 1, '우리은행 1111-111-111111')";
			
			break;

		default:
			sql= "insert into payment values(payment_no_seq.nextval, default, null)";
			break;
		}
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps= con.prepareStatement(sql);
			
			
			result = ps.executeUpdate();
			
			orderResult=orderInsert(con,oDTO);
			
			

			 
			
			
		} finally {
			con.commit();
			DbUtil.dbClose(null, ps, con);
			
		}
		
		
		return result;
		
	}
	

}
