package alcohol.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dto.UserDTO;

public interface UserDAO {

	/**
	 * 로그인 체크 select u_id , u_pwd, u_name from users where u_id=? and u_pwd=?
	 * */
	public UserDTO loginCheck(UserDTO userDTO)throws SQLException;
	
	/**
	 * 회원가입(등록) INSERT INTO USERS (U_ID, U_PWD,U_NAME,U_JUMIN,U_PHONE,U_EMAIL,U_ADDR
	 * U_ADDR2,U_GRADE,U_POINT,JOIN_DATE) VALUES(?,?,?,?,?,?,?,?,0,0,SYSDATE)
	 * */
	public int insert(UserDTO userDTO)throws SQLException;
	
	/**
	 * 회원정보검색(페이징 처리)  
	 * select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM users ORDER BY join_date desc) a) where  rnum>=? and rnum <=? 
	 * */
	public List<UserDTO> usersAll(int paging)throws SQLException;
	
	/**
	 * 아이디에 해당하는 회원정보검색
	 * select * from users where u_id=? 
	 */
	public UserDTO selectByUserId(String id) throws SQLException;
	
	/**
	 * 아이디 중복여부 체크 SELECT U_ID FROM USERS WHERE U_ID=?
	 * */
	public boolean idCheck(String id)throws SQLException;
	
	/**
	 * 개인정보수정 UPDATE USERS SET U_PWD =? , U_PHONE =? ,U_ADDR=?,U_ADDR2=? WHERE U_ID=?
	 * */
	public int update(UserDTO userDTO)throws SQLException;
	
	
	/**
	 * 회원 탈퇴 DELETE FROM USERS WHERE U_ID=?, U_PWD=?
	 * */
	public int delete(String id, String pwd)throws SQLException;
	
	
	/**
	 * 아이디 찾기 SELECT U_ID FROM USERS WHERE U_NAME = ? AND U_PHONE =? AND U_EMAIL=?
	 * */
	public String idFind(String name, String phone, String email)throws SQLException;
	
	/**
	 * 비밀번호 찾기 SELECT U_PWD FROM USERS WHERE U_ID=? U_NAME = ? AND U_PHONE =? AND U_EMAIL=?
	 * */
	public String pwdFind(String id , String name, String phone, String email)throws SQLException;
	
	
	public int pointDelet(String id,int point)throws SQLException;
	
	public List<UserDTO> memeberAll()throws SQLException;
	
	public String totalPrice()throws SQLException;
	
}
