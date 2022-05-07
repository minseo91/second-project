package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.ProductDAO;
import alcohol.mvc.dao.ProductDAOImpl;
import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.CategoryDTO;
import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO dao = new ProductDAOImpl(); 
	@Override
	public void insert(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrice(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStuck(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String pCode) throws SQLException {
		int result = dao.delete(pCode);
		
		if(result==0){
			throw new SQLException(pCode + "게시물을 삭제할 수 없습니다.");
		}

	}

	@Override
	public List<ProductDTO> selectAll(String type,String filter) throws SQLException {
		List<ProductDTO> list =dao.selectAll(type,filter);
		return list;
	}

	@Override
	public ProductDTO searchBy(String name) throws SQLException {
		ProductDTO dto = dao.searchBy(name);
		return dto;
	}

	@Override
	public List<ProductDTO> selectCategory(String type, String alcohol,String filter) throws SQLException {
		List<ProductDTO> list = dao.selectCategory(type, alcohol,filter);
		return list;
	}

	@Override
	public List<ProductDTO> selectDate(String type, String alcohol) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//goods.jsp
	@Override
	public List<ProductDTO> selectGoods() throws SQLException {
		
		List<ProductDTO> list = dao.selectGoods();
		
		return list;
	}

	@Override
	public List<ProductDTO> cartSelect(List<CartDTO> list) throws SQLException {
		List<ProductDTO> dto =dao.cartSelect(list);
		return dto;
	}

	@Override
	public List<OrderLineDTO> cateSelect() throws SQLException {
		List<OrderLineDTO> dto =dao.cateSelect();
		return dto;
	}

	@Override
	public List<ProductDTO> selectByCode(List<OrderLineDTO> list) throws SQLException {
		List<ProductDTO> dto = dao.selectByCode(list);
		return dto;
	}

	@Override
	public void insertwrite(ProductDTO dto) throws SQLException {
		int result = dao.insertwrite(dto);
		if(result==0) {
			throw new SQLException("등록 오류가 발생했습니다.");
		}
	}

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> list =dao.selectAll();
		return list;
	}

	@Override
	public List<ProductDTO> selectByDate() throws SQLException {
		List<ProductDTO> list =dao.selectByDate();
		return list;
	}
	
	

	
	

}
