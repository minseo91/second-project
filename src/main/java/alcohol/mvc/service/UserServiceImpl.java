package alcohol.mvc.service;

import java.sql.SQLException;
import java.util.List;

import alcohol.mvc.dao.UserDAO;
import alcohol.mvc.dao.UserDAOImpl;
import alcohol.mvc.dto.UserDTO;

public class UserServiceImpl implements UserService {

	private UserDAO userDao = new UserDAOImpl();

	// 로그인 체크
	@Override
	public UserDTO loginCheck(UserDTO userDto) throws SQLException {

		UserDTO dbDTO = userDao.loginCheck(userDto);
		if (dbDTO == null) {
			throw new SQLException("입력하신 정보가 틀립니다.");
		}

		return dbDTO;

	}

	// 회원가입
	@Override
	public void insert(UserDTO userDTO) throws SQLException {

		int result = userDao.insert(userDTO);
		if (result == 0) {
			throw new SQLException("회원가입에 실패하였습니다.");
		}

	}

	// 회원정보 검색
	@Override
	public List<UserDTO> usersAll(int paging) throws SQLException {

		List<UserDTO> list = userDao.usersAll(paging);

		return list;
	}

	// 아이디 중복체크
	@Override
	public void idCheck(String id) throws SQLException {

		if (userDao.idCheck(id) == false) {
			throw new SQLException("중복된 아이디입니다.");
		}

	}

	// 회원정보 수정
	@Override
	public void update(UserDTO userDTO) throws SQLException {

		// 비밀번호 검증(인수로 전달된 비번과 DB에 저장된 비번 비교)
		UserDTO dbUser = userDao.selectByUserId(userDTO.getUserId());
		if (dbUser == null) {
			throw new SQLException("오류로 수정할 수 없습니다.");
		} else if (!dbUser.getUserPwd().equals(userDTO.getUserPwd())) {
			throw new SQLException("비밀번호 오류로 수정할 수 없습니다.");
		}

		if (userDao.update(userDTO) == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

		userDao.update(userDTO);

	}

	// 회원탈퇴
	@Override
	public void delete(String id, String pwd) throws SQLException {

		// 비밀번호 일치 여부 체크
		UserDTO dbUser = userDao.selectByUserId(id);

		if (!dbUser.getUserPwd().equals(pwd)) { // 비밀번호 오류
			throw new SQLException("비밀번호 오류로 회원탈퇴에 실패했습니다.");
		}

	}

	// 아이디 찾기
	@Override
	public String idFind(String name, String phone, String email) throws SQLException {
		
		String result = userDao.idFind(name, phone, email);
		
		if(result == null) {
			throw new SQLException("입력하신 정보에 해당하는 id가 존재하지 않습니다.");
		}
		
		return result;
	}

	// 비밀번호 찾기
	@Override
	public String pwdFind(String id , String name, String phone, String email) throws SQLException {
		
		String result = userDao.pwdFind(id, name, phone, email);
		
		if(result == null) {
			throw new SQLException("입력하신 정보에 해당하는 pwd가 존재하지 않습니다.");
		}
		
		return result;
	}

	@Override
	public UserDTO selectByUserId(String id) throws SQLException {
		UserDTO dto = userDao.selectByUserId(id);
		return dto;
	}

	@Override
	public int pointDelet(String id,int point) throws SQLException {
		int result = userDao.pointDelet(id,point);
		return result;
	}



	@Override
	public String totalPrice() throws SQLException {
		String p = userDao.totalPrice();
		return p;
	}

	@Override
	public List<UserDTO> memeberAll() throws SQLException {
		List<UserDTO> list = userDao.memeberAll();
		return list;
	}
	
	

}
