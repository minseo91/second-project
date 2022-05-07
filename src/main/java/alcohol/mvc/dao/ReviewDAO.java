package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.ReviewDTO;

public interface ReviewDAO {

	/**
	 * 등록하기 INSERT INTO REVIEW VALUES(review_no_seq.nextval,?,?,?,?,?)
	 * */
	public int reviewInsert(ReviewDTO dto)throws SQLException;
	/**
	 * 삭제하기 DELETE FROM REVIEW WHERE VIEW_NUMBDER=?
	 * */
	public int reviewDelete(int vNumber)throws SQLException;
	
	/**
	 * 전체검색 SELECT * FROM REVIEW WHERE P_CODE=?
	 **/
	public List<ReviewDTO> reviewAll(int paging)throws SQLException;
	
	/**
	 * 수정하기 UPDATE REVIEW SET VIEW_CONTENT=? WHERE VIEW_NUMBER=?
	 * */
	public int reviewUpdate(ReviewDTO dto)throws SQLException;
	
	
	
	/**
	 * 선택상품 검색 select * from review where p_code =(select p_code from product where p_name = ?)
	 * */
	public List<ReviewDTO> reviewSelect(String pName,int paging)throws SQLException;
	
	
	
	public int avgReview(String pCode)throws SQLException;
	
	
	
	
	
	
}
