package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.util.DbUtil;

	public class CartDAOImpl implements CartDAO {

		@Override
		public List<CartDTO> selectAll(String id) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			List<CartDTO> cartList = new ArrayList<CartDTO>();
			CartDTO cartDTO = null;
			
			String sql = "SELECT * FROM CART WHERE U_ID=?";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					cartDTO = new CartDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
					
					cartList.add(cartDTO);
					
				}
				
			} finally {
				DbUtil.dbClose(rs, ps, con);
			}
			
			
			return cartList;
		}

		@Override
		public int cartInsert(CartDTO dto) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
		    int result = 0;
			
			String sql = "INSERT INTO CART VALUES(cart_no_seq.nextval,?,?,?)";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setString(1, dto.getuId());
				ps.setString(2, dto.getpCode());
				ps.setInt(3, dto.getCartCount());
				
				result = ps.executeUpdate();
				
			} finally {
				DbUtil.dbClose(ps, con);
			}
			
			return result;
		}

		@Override
		public int cartUpdate(CartDTO dto) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			int result = 0;
			
			String sql = "UPDATE CART SET CART_COUNT =? WHERE CART_NUMBER=?";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, dto.getCartCount());
				ps.setInt(2, dto.getCartNumber());
				
				result = ps.executeUpdate();
				
			} finally {
				DbUtil.dbClose(ps, con);
			}
			
			return result;
		}

		@Override
		public int cartDelete(int cartNo) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			int result = 0;
			String sql = "DELETE FROM CART WHERE CART_NUMBER=?";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, cartNo);
				
				result = ps.executeUpdate();
			} finally {
				DbUtil.dbClose(ps, con);
			}
			
			System.out.println(result);
			return result;
		}

		@Override
		public List<ProductDTO> cartOrders(String id) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<ProductDTO> list = new ArrayList<ProductDTO>();
			ProductDTO dto = null;
			String sql = "select a.*,b.cart_count, (a.p_price*b.cart_count) from product a , cart b where b.p_code=a.p_code and b.u_id=?";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					dto = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
							,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12),rs.getInt(13),rs.getInt(14));
					list.add(dto);
					
					
					
				}
				
			} finally {
				DbUtil.dbClose(rs, ps, con);
			}
			
			
			return list;
		}
		
		
		
		
		public int cartOrderDelete(String id) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			int result = 0;
			String sql = "DELETE FROM CART WHERE U_ID=?";
			
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				result = ps.executeUpdate();
			} finally {
				DbUtil.dbClose(ps, con);
			}
			
			System.out.println(result);
			return result;
		}
			
	}



