package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.OrdersDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.util.DbUtil;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public int orderInsert(List<OrdersDTO> list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "INSERT INTO ORDERS(ORDER_CODE,U_ID,PAY_CODE) VALUES(orders_no_seq.nextval,?,?,SYSDATE,?,?,?,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, sql);
			ps.setString(2, sql);
			ps.setString(3, sql);
			ps.setString(4, sql);
			ps.setString(5, sql);
			ps.setString(6, sql);
			ps.setString(7, sql);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int orderUpdate(OrdersDTO ordersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "UPDATE ORDERS SET ORDER_STATUS=? WHERE ORDER_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ordersDTO.getOrderStatus());
			ps.setInt(2, ordersDTO.getOrderCode());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
				
		return result;
	}

	@Override
	public String orderStatus(int oCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String status = null;
		
		String sql = "SELECT ORDER_STATUS FROM ORDERS WHERE ORDER_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				status = rs.getString(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
				
		return status;
	}

	@Override
	public int deliUpdate(OrdersDTO ordersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "UPDATE ORDERS SET DELI_STATUS=? WHERE ORDER_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ordersDTO.getDeliStatus());
			ps.setInt(2, ordersDTO.getOrderCode());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
			
		return result;
	}

	@Override
	public String deliStatus(int oCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String status = null;
		
		String sql = "SELECT DELI_STATUS FROM ORDERS WHERE ORDER_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oCode);
			
            rs = ps.executeQuery();
			
			if(rs.next()) {
				status = rs.getString(1);
			}
				
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return status;
	}

	@Override
	public List<OrdersDTO> orderAll(int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
		String sql ="select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM orders ORDER BY order_date) a) where  rnum>=? and rnum <=? "; 
		
		try {
			
			//전체레코드 수를 구해서 총페이지수를 구하고 db에서 꺼내 올 게시물의 개수를 pagesize만큼 가져온다.(시작 ~ 끝)
			int totalCount = this.getTotalCount();
			int totalPage = totalCount%PageCnt.getPagesize() ==0 ? totalCount/PageCnt.getPagesize() : (totalCount/PageCnt.getPagesize())+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);//전체페이지수를 저장해준다.
			pageCnt.setPageNo(pageNo); //사용자가 클릭한 page번호를 설정
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, (pageNo-1)*PageCnt.pagesize+1); //시작점번호
			ps.setInt(2, pageNo*PageCnt.pagesize); //끝점 번호 

			rs = ps.executeQuery();

			while(rs.next()) {
				OrdersDTO orders = new OrdersDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
						,rs.getString(8),rs.getString(9));
				ordersList.add(orders);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(ordersList.get(0).getOrderStatus());
		return ordersList;
	}
	
	/**
	 * 전체레코드수 가져오기 
	 * */
	private int getTotalCount() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalCount=0;
		String sql = "select count(*) from notice";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return totalCount;
	}
	

}
