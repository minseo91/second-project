package alcohol.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import alcohol.mvc.dto.UserDTO;
import alcohol.mvc.paging.PageCnt;
import alcohol.mvc.util.DbUtil;
import oracle.jdbc.proxy.annotation.Pre;

public class UserDAOImpl implements UserDAO {

	// 로그인 체크
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM USERS WHERE U_ID=? AND U_PWD=?";
		UserDTO dbDTO = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());

			rs = ps.executeQuery();
			if (rs.next()) {
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getInt(9),
						rs.getInt(10), rs.getString(11));
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dbDTO;
	}

	// 회원가입
	@Override
	public int insert(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO USERS(U_ID, U_PWD,U_NAME,U_JUMIN,U_PHONE,U_EMAIL,U_ADDR,U_ADDR2,U_ADDR3,U_GRADE,U_POINT,JOIN_DATE) VALUES(?,?,?,?,?,?,?,?,?,0,0,SYSDATE)";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getUserPwd());
			ps.setString(3, userDTO.getUserName());
			ps.setString(4, userDTO.getUserJumin());
			ps.setString(5, userDTO.getUserPhone());
			ps.setString(6, userDTO.getUserEmail());
			ps.setString(7, userDTO.getUserAddr());
			ps.setString(8, userDTO.getUserAddr2());
			ps.setString(9, userDTO.getUserAddr3());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	// 회원정보 검색
	@Override
	public List<UserDTO> usersAll(int paging) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<UserDTO> userList = new ArrayList<UserDTO>();
		String sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM users ORDER BY join_date desc) a) where  rnum>=? and rnum <=?";

		try {

			// 전체 레코드 수를 구해서 총 페이지 수를 구하고 DB에서 꺼내올 게시물의 개수를 pagesize만큼 가져온다.
			int totalCount = this.getTotalCount();
			int totalPage = totalCount % PageCnt.getPagesize() == 0 ? totalCount / PageCnt.getPagesize()
					: (totalCount / PageCnt.getPagesize()) + 1;

			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage); // 전체 페이지 수를 저장해준다.
			pageCnt.setPageNo(paging); // 사용자가 클릭한 page의 번호를 설정

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, (paging - 1) * PageCnt.pagesize + 1); // 시작점 번호
			ps.setInt(2, paging * pageCnt.pagesize); // 끝점 번호

			rs = ps.executeQuery();

			while (rs.next()) {
				UserDTO userDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12),
						rs.getInt(9), rs.getInt(10), rs.getString(11));

				userList.add(userDTO);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return userList;
	}

	/**
	 * 아이디에 해당하는 회원정보 검색
	 */
	@Override
	public UserDTO selectByUserId(String id) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		String sql = " select * from users where u_id=?";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				userDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12),
						rs.getInt(9), rs.getInt(10), rs.getString(11));
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return userDTO;
	}

	/**
	 * 전체 레코드 수 가져오기
	 */
	private int getTotalCount() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalCount = 0;
		String sql = "select count(*) from users";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return totalCount;
	}

	// 아이디 중복확인
	@Override
	public boolean idCheck(String id) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT U_ID FROM USERS WHERE U_ID=?";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return result;
	}

	// 회원정보 수정
	@Override
	public int update(UserDTO userDTO) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE USERS SET U_PWD =? , U_PHONE =?, U_ADDR=?, U_ADDR2=?, U_ADDR3=? WHERE U_ID=?";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, userDTO.getUserPwd());
			ps.setString(2, userDTO.getUserPhone());
			ps.setString(3, userDTO.getUserAddr());
			ps.setString(4, userDTO.getUserAddr2());
			ps.setString(5, userDTO.getUserAddr3());
			ps.setString(6, userDTO.getUserId());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	// 회원 탈퇴
	@Override
	public int delete(String id, String pwd) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = " DELETE FROM USERS WHERE U_ID=?, U_PWD=?";

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, pwd);

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	// 아이디 찾기
	@Override
	public String idFind(String name, String phone, String email) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		String sql = "SELECT U_ID FROM USERS WHERE U_NAME=? AND U_PHONE=? AND U_EMAIL=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return id;
	}

	// 비밀번호 찾기
	@Override
	public String pwdFind(String id, String name, String phone, String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		String sql = "SELECT U_PWD FROM USERS WHERE U_ID=? AND U_NAME=? AND U_PHONE=? AND U_EMAIL=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, phone);
			ps.setString(4, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				pwd = rs.getString(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return pwd;
	}

	@Override
	public int pointDelet(String id,int point) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "update users set u_point=? where u_id=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, point);
			ps.setString(2, id);	
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
		
		
		
		
	}



	@Override
	public String totalPrice() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		String sql = "select sum(p_price*order_line_count) from (select a.*,b.p_price from(select a.* ,b.p_code,b.order_line_count from (select a.* from orders a, order_line b where a.order_code=b.order_code) a ,(select * from order_line) b where a.order_code= b.order_code\r\n"
				+ ")a ,product b where a.p_code = b.p_code and u_id =?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);


			rs = ps.executeQuery();
			if (rs.next()) {
				pwd = rs.getString(1);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return pwd;
	}

	@Override
	public List<UserDTO> memeberAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		UserDTO dto = null;
		
		
		String sql = "select a.join_date,a.u_id,a.u_name,a.u_phone,b.* from users a left outer join (select u_id, sum(p_price*order_line_count) from (select a.*,b.p_price from(select a.* ,b.p_code,b.order_line_count from (select a.* from orders a, order_line b where a.order_code=b.order_code) a ,(select * from order_line) b where a.order_code= b.order_code\r\n"
				+ ")a ,product b where a.p_code = b.p_code ) group by u_id) b on a.u_id=b.u_id";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);


			rs = ps.executeQuery();
			while(rs.next()) {
				dto=new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6));
				list.add(dto);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

}
