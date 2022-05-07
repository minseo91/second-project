package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.CategoryDTO;
import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.ProductDTO;
import alcohol.mvc.util.DbUtil;
import oracle.jdbc.driver.DBConversion;
import oracle.jdbc.proxy.annotation.Pre;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int insert(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePrice(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStuck(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "DELETE FROM PRODUCT WHERE P_CODE=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pCode);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	/**
	 * 상품 전체 검색 SELECT * FROM PRODUCT  뒤에 정렬은 나중에 정하기로함 
	 * 조건검색(검색필드와 검색단어를 전달받아 검색필드에 검색단어를포함한 레코드를 검색하기 )
	 *   SELECT * FROM PRODUCT orderby 인기순(판매량) ?
         SELECT * FROM PRODUCT  최신순?
         SELECT * FROM PRODUCT  디폴트값? 
         이런느낌
         step 14 dbcp dao처럼
	 * 
	 * */
	@Override
	public List<ProductDTO> selectAll(String type,String filter) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();



		String sql ="";
		switch(filter) {
		case "0" : sql = "SELECT * FROM PRODUCT WHERE CATE_CODE=? ORDER BY P_CODE";break;
		case "null" : sql = "SELECT * FROM PRODUCT WHERE CATE_CODE=? ORDER BY P_CODE";break;
		case "1" : sql = "SELECT * FROM PRODUCT WHERE CATE_CODE=? ORDER BY P_STUCK ASC";break;
		case "2" : sql = "SELECT * FROM PRODUCT WHERE CATE_CODE=? ORDER BY VIEW_SCORE ASC";break;
		}




		ProductDTO product = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();

			while(rs.next()) {
				product = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
						,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
				list.add(product);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(list.get(0).getpName());
		return list;
	}

	@Override
	public ProductDTO searchBy(String name) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ProductDTO product = null;
		String sql = "SELECT * FROM PRODUCT WHERE P_NAME=?";		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				product = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
						,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
			}	
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return product;
	}

	@Override
	public List<ProductDTO> selectCategory(String type,String alcohol,String filter) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String alNo = alcohol;
		int no = Integer.parseInt(alNo);
		int result = (no-10);



		String sql ="";

		switch(filter) {
		case "0" : sql = "SELECT * FROM PRODUCT WHERE P_ALCOHOL < ? AND P_ALCOHOL >=? AND CATE_CODE=? ORDER BY P_CODE";break;
		case "null" : sql = "SELECT * FROM PRODUCT WHERE P_ALCOHOL < ? AND P_ALCOHOL >=? AND CATE_CODE=? ORDER BY P_CODE";break;
		case "1" : sql = "SELECT * FROM PRODUCT WHERE P_ALCOHOL < ? AND P_ALCOHOL >=? AND CATE_CODE=? ORDER BY P_STUCK ASC";break;
		case "2" : sql = "SELECT * FROM PRODUCT WHERE P_ALCOHOL < ? AND P_ALCOHOL >=? AND CATE_CODE=? ORDER BY VIEW_SCORE ASC";break;
		}





		ProductDTO product = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, alcohol);
			ps.setFloat(2, result);
			ps.setString(3, type);
			rs = ps.executeQuery();
			while(rs.next()) {
				product = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
						,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
				list.add(product);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectDate(String type, String alcohol) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public int productNo(String pCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result= 0;

		String sql ="select count(order_line_count) from order_line where p_code =?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(result);
		return result;
	}


	//goods.jsp를 위한 selectAll

	public List<ProductDTO> selectGoods() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ProductDTO> list = new ArrayList<ProductDTO>();
		ProductDTO proDto = null;

		String sql = "select p_code,cate_code,p_name,p_alcohol,p_price,p_stuck,p_date,p_detail from product order by p_code";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			

			while(rs.next()) {
				proDto = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8));

				list.add(proDto);

			}

		} finally {
			DbUtil.dbClose(rs, ps, con);

		}

		return list;
	}

	@Override
	public List<ProductDTO> cartSelect(List<CartDTO> cartlist) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ProductDTO> list = new ArrayList<ProductDTO>();

		ProductDTO proDto = null;

		String sql = "SELECT * FROM PRODUCT WHERE P_CODE=?";

		try {
			for (CartDTO cart : cartlist) {

				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);	
				ps.setString(1, cart.getpCode());
				rs = ps.executeQuery();

				while(rs.next()) {
					proDto = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)
							,rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));

					list.add(proDto);			
				}	
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);	
		}
		return list;
	}

	@Override
	public List<OrderLineDTO> cateSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<OrderLineDTO> list = new ArrayList<OrderLineDTO>();
		OrderLineDTO dto = null;

		
		String sql = "select * from (select  p_code, sum(order_line_count) from order_line group by p_code order by sum(order_line_count) desc) where rownum<=3";
		

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				dto = new OrderLineDTO(rs.getString(1),rs.getInt(2));

				list.add(dto);

			}

		} finally {
			DbUtil.dbClose(rs, ps, con);

		}

		return list;
	}


	//goods.writer
	public int insertwrite(ProductDTO dto) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?,?,0)";

				try {
					con = DbUtil.getConnection();
					ps = con.prepareStatement(sql);
					
					ps.setString(1, dto.getpCode());
					ps.setString(2, dto.getCateCode());
					ps.setString(3, dto.getpName());
					ps.setInt(4, dto.getpAlcohol());
					ps.setInt(5, dto.getpPrice());
					ps.setInt(6, dto.getpStuck());
					ps.setString(7, dto.getpDate());
					ps.setString(8, dto.getpImage());
					ps.setString(9, dto.getpDetail());
					ps.setString(10, dto.getpImage()+"2");
					ps.setString(11, dto.getpImage()+"3");

					
					result = ps.executeUpdate();

				} finally {
					DbUtil.dbClose(ps, con);
				}

		return result;
	}





	@Override
	public List<ProductDTO> selectByCode(List<OrderLineDTO> list) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		List<ProductDTO> proList = new ArrayList<ProductDTO>();
		ProductDTO proDto = null;
		
		String sql = "SELECT * FROM PRODUCT WHERE P_CODE=?";		
		try {
			for( OrderLineDTO orderDto : list) {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, orderDto.getpCode());
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					proDto = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
							,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
					
					proList.add(proDto);
			}
			
			}	
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return proList;
	}

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();

		String sql ="SELECT * FROM PRODUCT"; //
		
		ProductDTO product = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();

			while(rs.next()) {
				product = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
						,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
				list.add(product);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(list.get(0).getpName());
		return list;
	}

	@Override
	public List<ProductDTO> selectByDate() throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();

		String sql ="select * from (select * from product order by p_date desc) where rownum <=3"; //select * from (select * from product order by p_date desc) where rownum <=3;
		
		ProductDTO product = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();

			while(rs.next()) {
				product = new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getString(7)
						,rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(9),rs.getInt(12));
				list.add(product);
			}


		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(list.get(0).getpName());
		return list;
	}	

}
