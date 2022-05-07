package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * 등록하기
	 * */
	public void reviewInsert(ReviewDTO dto)throws SQLException;
	
	/**
	 * 삭제하기(관리자만)
	 * */
	public void reviewDelete(int vNumber)throws SQLException;
	
	/**
	 * 전체검색
	 **/
	public List<ReviewDTO> reviewAll(int paging)throws SQLException;
	
	/**
	 * 수정하기
	 * */
	public void reviewUpdate(ReviewDTO dto)throws SQLException;
	
	/**
	 * 선택상품 검색
	 * */
	public List<ReviewDTO> reviewSelect(String pName,int paging)throws SQLException;
	
	/**
	 * 리뷰 평점 계산
	 * SELECT * FROM (select  p_code, AVG(VIEW_SCORE) from REVIEW group by p_code) where p_code=?
	 * */
	public int avgReview(String pCode)throws SQLException;
}
