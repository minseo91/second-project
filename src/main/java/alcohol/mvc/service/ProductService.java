package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.CartDTO;
import alcohol.mvc.dto.CategoryDTO;
import alcohol.mvc.dto.OrderLineDTO;
import alcohol.mvc.dto.ProductDTO;

public interface ProductService {
	/**
	 * 상품 등록
	 * */
	public void insert(ProductDTO productDTO)throws SQLException;
	
	
	/**
	 * 상품 수정 
	 * */
	public void updatePrice(ProductDTO productDTO)throws SQLException;
	
	/**
	 * 재고량 수정 
	 * */
	public void updateStuck(ProductDTO productDTO)throws SQLException;
	
	/**
	 * 상품 제거 delete from product where pCode
	 * @return 
	 * */
	public void delete(String pCode)throws SQLException;
	
	/**
	 * 상품 전체 검색 SELECT * FROM PRODUCT  뒤에 정렬은 나중에 정하기로함 
	 * 조건검색(검색필드와 검색단어를 전달받아 검색필드에 검색단어를포함한 레코드를 검색하기 )
	 *   SELECT * FROM PRODUCT orderby 인기순(판매량) ?
         SELECT * FROM PRODUCT  최신순?
         SELECT * FROM PRODUCT  디폴트값? 
         이런느낌   
	 * 
	 * */
	public  List<ProductDTO> selectAll(String type,String filter)throws SQLException;
	

	
	/**
	 * 상품 상세 검색
	 * */
	public ProductDTO searchBy(String name)throws SQLException;
	
	/**
	 * 도수별 검색
	 * */
	public List<ProductDTO> selectCategory(String type,String alcohol,String filter)throws SQLException;
	/**
	 *날짜 판매 
	 * */
	public List<ProductDTO> selectDate(String type,String alcohol)throws SQLException;


	//goods.jsp
	public List<ProductDTO> selectGoods() throws SQLException;

	
	/**
	 * cartSelect
	 * */
	public List<ProductDTO> cartSelect(List<CartDTO> list) throws SQLException;
	
	public List<OrderLineDTO> cateSelect() throws SQLException;


	//goodswrite.jsp
	public void insertwrite(ProductDTO dto) throws SQLException;
	
	public List<ProductDTO> selectByCode(List<OrderLineDTO> list) throws SQLException;
	
	public  List<ProductDTO> selectAll()throws SQLException;
	
	public  List<ProductDTO> selectByDate()throws SQLException;


	
	
}
